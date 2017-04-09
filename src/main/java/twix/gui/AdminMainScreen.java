package twix.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminMainScreen extends Presentation {
    
    public AdminMainScreen(Screens screens) {
        super(screens);
    }
    
    @FXML
    public void gotoDeleteUser(ActionEvent event) {
        config.loadAdminDeleteScreen();
    }

    @FXML
    public void gotoEditUser(ActionEvent event) {
        config.loadAdminEditUserScreen();
    }
    
    @FXML
    public void gotoRezerwacje(ActionEvent event) {
        config.loadAdminRezerwacjeScreen();
    }
    
    @FXML
    public void gotoAddScore(ActionEvent event) {
        config.loadAdminAddScoreScreen();
    }
    
    @FXML
    public void gotoMainScreen(ActionEvent event) {
        config.loadMainScreen();
    }
}
