package twix.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreen extends Presentation {
    
    public MainScreen(Screens screens) {
        super(screens);
    }
    
    @FXML
    public void gotoRegister(ActionEvent event) {
        config.loadRegisterScreen();
    }
    
    @FXML
    public void gotoLogin(ActionEvent event) {
        config.loadLoginScreen();
    }
    
}
