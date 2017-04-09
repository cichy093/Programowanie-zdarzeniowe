package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import twix.database.TwixKlienci;
import twix.login.Login;
import twix.repository.KlientRepository;

public class LoginScreen extends Presentation {

    @Autowired
    private KlientRepository klientRepository;
    
    public LoginScreen(Screens screens) {
        super(screens);
    }

    @FXML
    TextField inputLogin;
    
    @FXML
    TextField inputHaslo;
    
    @FXML
    public void login(ActionEvent event) {
        if (validateHaslo() && validateLogin()) {
            TwixKlienci klient = klientRepository.getByLoginAndPassword(inputLogin.getText(), inputHaslo.getText());
            
            if (klient != null) {
                Login.setZalogowanyUzytkownik(klient);
                
                inputHaslo.setText("");
                inputLogin.setText("");
                
                if (klient.getCzyAdmin() == 0) {
                    config.loadUserMainScreen();
                } else {
                    config.loadAdminMainScreen();
                }
            } else {
                addOrRemoveBadInput(inputLogin, false);  
            }
        }
    }

    @FXML
    public boolean validateHaslo() {
        boolean verified = inputNotEmpty(inputHaslo);
        addOrRemoveBadInput(inputHaslo, verified);
        return verified;
    }
    
    @FXML
    public boolean validateLogin() {
        boolean verified = inputNotEmpty(inputLogin);
        addOrRemoveBadInput(inputLogin, verified);
        return verified;
    }
    
    private boolean inputNotEmpty(TextField tf) {
        return !tf.getText().isEmpty();
    }
    
    private void addOrRemoveBadInput(TextField tf, boolean verified) {
        if (!verified && !tf.getStyleClass().contains("badInput")) {
            tf.getStyleClass().add("badInput");
        } else if (verified) {
            tf.getStyleClass().remove("badInput");
        }
    }

    @FXML
    public void gotoMainScreen(ActionEvent event) {
        config.loadMainScreen();
    }
}
