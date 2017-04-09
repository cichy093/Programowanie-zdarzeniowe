package twix.gui;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import twix.database.TwixRezerwacja;
import twix.database.TwixSLTorow;
import twix.login.Login;
import twix.repository.RezerwacjaRepository;
import twix.repository.TorRepository;

public class UserRezerwacjaScreen extends Presentation {
    
    @Autowired
    RezerwacjaRepository rezerwacjaRepository;
    
    @Autowired
    TorRepository torRepository;
    
    private List<TwixRezerwacja> rezerwacje;
    
    public UserRezerwacjaScreen(Screens screens) {
        super(screens);
    }
    
    @FXML
    DatePicker datepicker;
    
    @FXML
    ComboBox<TwixSLTorow> inputTor;

    @FXML
    ComboBox<Integer> inputCzas;

    @FXML
    public void dateSelected(ActionEvent event) {
        validateForCollisions();
    }
    
    @FXML
    public void torSelected(ActionEvent event) {
        validateForCollisions();
    }
    
    @FXML
    public void czasSelected(ActionEvent event) {
        validateForCollisions();
    }
    
    private Date selectedDate() {
        return Date.from(datepicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
    }
    
    private boolean validateForCollisions() {
        datepicker.getStyleClass().remove("badInput");
        inputCzas.getStyleClass().remove("badInput");
        inputTor.getStyleClass().remove("badInput");
        
        if (inputCzas.getValue() == null 
                || inputTor.getValue() == null
                || datepicker.getValue() == null)
            return false;
        
        List<TwixRezerwacja> kolizje = rezerwacje.stream()
                .filter(e -> e.getData().equals(selectedDate()))
                .filter(e -> e.getIdToru().equals(inputTor.getValue().getId()))
                .filter(e -> e.getCzas().equals(inputCzas.getValue()))
                .collect(Collectors.toList());
        
        if (kolizje.size() > 0) {
            datepicker.getStyleClass().add("badInput");
            inputCzas.getStyleClass().add("badInput");
            inputTor.getStyleClass().add("badInput");
            return true;
        }
        return false;
    }
    
    @FXML
    public void rezerwuj(ActionEvent event) {
        if (validateForCollisions())
            return;
        
        TwixRezerwacja rezerwacja = new TwixRezerwacja();
        rezerwacja.setCzas(inputCzas.getValue());
        rezerwacja.setIdToru(inputTor.getValue().getId());
        rezerwacja.setData(selectedDate());
        rezerwacja.setIdKlienta(Login.getZalogowanyUzytkownik().getId());
        
        rezerwacjaRepository.save(rezerwacja);
        rezerwacje.add(rezerwacja);
    }
    
    @FXML
    public void initialize() {
        rezerwacje = rezerwacjaRepository.getAll();
        List<TwixSLTorow> tory = torRepository.getAll();
        
        inputTor.setItems(FXCollections.observableList(tory));
        inputCzas.setItems(FXCollections.observableArrayList(8,9,10,11,12,13,14,15,16,17,18));
    }
    
    @FXML
    public void gotoUserMainScreen(ActionEvent event) {
        config.loadUserMainScreen();
    }
    
}
