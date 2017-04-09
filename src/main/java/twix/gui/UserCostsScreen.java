package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import twix.database.TwixSLBroni;
import twix.repository.BronRepository;

public class UserCostsScreen extends Presentation {
    
    @Autowired
    BronRepository bronRepository;
    
    public UserCostsScreen(Screens screens) {
        super(screens);
    }
    
    @FXML
    ComboBox<TwixSLBroni> comboBoxBron;
    
    @FXML
    TextField inputIloscNaboi;
    
    @FXML
    Label labelCena;
    
    @FXML
    void oblicz(ActionEvent event) {
        inputIloscNaboi.getStyleClass().remove("badInput");
        comboBoxBron.getStyleClass().remove("badInput");
        
        if (comboBoxBron.getValue() == null) {
            comboBoxBron.getStyleClass().add("badInput");
            return;
        }
        
        try {
            Integer ile = Integer.decode(inputIloscNaboi.getText());
            labelCena.setText(String.valueOf(ile * comboBoxBron.getValue().getCena()));
        } catch (NumberFormatException e) {
            inputIloscNaboi.getStyleClass().add("badInput");
        }
    }

    @FXML
    void gotoUserMainScreen(ActionEvent event) {
        config.loadUserMainScreen();
    }
    
    @FXML
    void initialize() {
        comboBoxBron.setItems(FXCollections.observableList(
                bronRepository.getBronZAmunicja()));
    }
}
