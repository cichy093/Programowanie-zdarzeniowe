package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import twix.database.TwixKlienci;
import twix.repository.KlientRepository;

public class AdminDeleteUserScreen extends Presentation {
    
    public AdminDeleteUserScreen(Screens screens) {
        super(screens);
    }

    @Autowired
    private KlientRepository klientRepository;

    @FXML
    TextField inputSearchPesel;

    @FXML
    TextField inputEditImie;

    @FXML
    TextField inputEditNazwisko;

    @FXML
    TextField inputEditPesel;

    @FXML
    TextField inputEditDowod;

    @FXML
    TextField inputEditLogin;
    
    @FXML
    Button buttonSzukaj;
    
    private TwixKlienci foundUser;
    
    @FXML
    public void szukaj(ActionEvent event) {
        buttonSzukaj.getStyleClass().remove("badInput");
        inputSearchPesel.getStyleClass().remove("badInput");
        foundUser = klientRepository.getByPesel(inputSearchPesel.getText());
        
        if (foundUser == null) {
            buttonSzukaj.getStyleClass().add("badInput");
            inputSearchPesel.getStyleClass().add("badInput");
        } else {
            inputEditImie.setText(foundUser.getImie());
            inputEditNazwisko.setText(foundUser.getNazwisko());
            inputEditPesel.setText(foundUser.getPesel());
            inputEditDowod.setText(foundUser.getNrDowodu());
            inputEditLogin.setText(foundUser.getLogin());
        }
    }
    
    @FXML
    public void usun(ActionEvent event) {
        buttonSzukaj.getStyleClass().remove("badInput");
        if (foundUser == null) {
            buttonSzukaj.getStyleClass().add("badInput");
        } else {
            klientRepository.delete(foundUser);
            inputEditImie.setText("");
            inputEditNazwisko.setText("");
            inputEditPesel.setText("");
            inputEditDowod.setText("");
            inputEditLogin.setText("");
            inputSearchPesel.setText("");
        }
    }
    
    @FXML
    public void gotoAdminMainScreen(ActionEvent event) {
        config.loadAdminMainScreen();
    }
    
    
    

}
