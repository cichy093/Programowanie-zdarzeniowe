package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import twix.database.TwixRezerwacja;
import twix.database.TwixWyniki;
import twix.login.Login;
import twix.repository.RezerwacjaRepository;

public class UserMainScreen extends Presentation {
    
    public UserMainScreen(Screens screens) {
        super(screens);
    }

    @FXML
    Label labelLogin;
    
    @FXML
    Label labelRanga;
    
    @FXML
    public void gotoUserStats(ActionEvent event) {
        config.loadUserStatsScreen();
    }
    
    @FXML
    public void gotoRanking(ActionEvent event) {
        config.loadRankingScreen();
    }
    
    @FXML
    public void gotoRezerwacjaTerminu(ActionEvent event) {
        config.loadUserRezerwacjaScreen();
    }
    
    @FXML
    public void gotoObliczKoszty(ActionEvent event) {
        config.loadUserCostsScreen();
    }
    
    @FXML
    public void gotoMainScreen(ActionEvent event) {
        config.loadMainScreen();
    }
    
    @FXML
    ListView<TwixRezerwacja> listViewRezerwacje;
    
    @Autowired
    RezerwacjaRepository rezerwacjaRepository;

    @FXML
    public void initialize() {
        labelLogin.setText(Login.getZalogowanyUzytkownik().getLogin());
        labelRanga.setText(Login.getZalogowanyUzytkownik().getRanga().getNazwa());
        
        ObservableList<TwixRezerwacja> items = 
                FXCollections.observableList(
                        rezerwacjaRepository.getByLogin(Login.getZalogowanyUzytkownik().getLogin()));
        listViewRezerwacje.setItems(items);
    }
}
