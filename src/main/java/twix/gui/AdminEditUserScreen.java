package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import twix.database.TwixKlienci;
import twix.repository.KlientRepository;

public class AdminEditUserScreen extends Presentation {
    
    public AdminEditUserScreen(Screens screens) {
        super(screens);
    }
    
    @Autowired
    private KlientRepository klientRepository;
    
    @FXML
    TextField inputSearchPesel;

    @FXML
    TextField inputImie;

    @FXML
    TextField inputNazwisko;

    @FXML
    TextField inputPesel;

    @FXML
    TextField inputDowod;

    @FXML
    TextField inputLogin;

    @FXML
    TextField inputHaslo;

    @FXML
    TextField inputRanga;
    
    @FXML
    CheckBox inputAdmin;

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
            inputImie.setText(foundUser.getImie());
            inputNazwisko.setText(foundUser.getNazwisko());
            inputPesel.setText(foundUser.getPesel());
            inputDowod.setText(foundUser.getNrDowodu());
            inputLogin.setText(foundUser.getLogin());
            inputHaslo.setText("");
            inputRanga.setText(foundUser.getIdRangi().toString());
            inputAdmin.setSelected(foundUser.getCzyAdmin() == 1);
        }
    }

    
    @FXML
    public void zapisz(ActionEvent event) {
        
        buttonSzukaj.getStyleClass().remove("badInput");
        if (foundUser == null) {
            buttonSzukaj.getStyleClass().add("badInput");
        } else {
            if (!validateAllFields())
                return;
            
            foundUser.setCzyAdmin(inputAdmin.isSelected()?1:0);
            foundUser.setIdRangi(Integer.valueOf(inputRanga.getText()));
            if (inputHaslo.getText().length()>0) {
                foundUser.setHaslo(inputHaslo.getText());
            }
            foundUser.setImie(inputImie.getText());
            foundUser.setNazwisko(inputNazwisko.getText());
            foundUser.setPesel(inputPesel.getText());
            foundUser.setNrDowodu(inputDowod.getText());
            foundUser.setLogin(inputLogin.getText());
            
            klientRepository.save(foundUser);
        }
    }
    
    private boolean validateAllFields() {
        boolean test = true;

        if (!inputPesel.getText().equals(foundUser.getPesel()))
            test &= validatePeselExists();
        if (!inputDowod.getText().equals(foundUser.getNrDowodu()))
            test &= validateDowodExists();
        if (!inputLogin.getText().equals(foundUser.getLogin()))
            test &= validateLoginExists();
        
        return validateImie() && validateNazwisko() 
                && validatePesel() && validateDowod() && validateLogin()
                && test;
    }
    
    @FXML
    public boolean validateLogin() {
        boolean verified = inputNotEmpty(inputLogin);
        addOrRemoveBadInput(inputLogin, verified);
        return verified;
    }
    
    private boolean validateLoginExists() {
        boolean verified = !klientRepository.isClientByLoginExists(inputLogin.getText());
        addOrRemoveBadInput(inputLogin, verified);
        return verified;
    }
    
    @FXML
    public boolean validateDowod() {
        boolean verified = inputNotEmpty(inputDowod);
        addOrRemoveBadInput(inputDowod, verified);
        return verified;
    }
    
    private boolean validateDowodExists() {
        boolean verified = !klientRepository.isClientByDowodExists(inputDowod.getText());
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n" + inputDowod.getText());
        System.out.println(verified);
        addOrRemoveBadInput(inputDowod, verified);
        return verified;
    }
    
    @FXML
    public boolean validatePesel() {
        boolean verified = inputNotEmpty(inputPesel);
        addOrRemoveBadInput(inputPesel, verified);
        return verified;
    }
    
    private boolean validatePeselExists() {
        boolean verified = !klientRepository.isClientByPeselExists(inputPesel.getText());
        addOrRemoveBadInput(inputPesel, verified);
        return verified;
    }
    
    @FXML
    public boolean validateNazwisko() {
        boolean verified = inputNotEmpty(inputNazwisko);
        addOrRemoveBadInput(inputNazwisko, verified);
        return verified;
    }
    
    @FXML
    public boolean validateImie() {
        boolean verified = inputNotEmpty(inputImie);
        addOrRemoveBadInput(inputImie, verified);
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
    public void gotoAdminPanelScreen(ActionEvent event) {
        config.loadAdminMainScreen();
    }
    
}
