package twix.gui;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import twix.database.TwixKlienci;
import twix.repository.KlientRepository;

public class RegisterScreen extends Presentation {
    
    public RegisterScreen(Screens screens) {
        super(screens);
    }
    
    @Autowired
    private KlientRepository klientRepository;

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
    TextField inputPowtorzHaslo;
    
    @FXML
    public void gotoMainScreen(ActionEvent event) {
        config.loadMainScreen();
    }
    
    @FXML
    public void register(ActionEvent event) {
        if (validateAllFields()) {
            TwixKlienci nowyKlient = new TwixKlienci();
            nowyKlient.setIdRangi(1);
            nowyKlient.setCzyAdmin(0);
            nowyKlient.setHaslo(inputHaslo.getText());
            nowyKlient.setLogin(inputLogin.getText());
            nowyKlient.setNrDowodu(inputDowod.getText());
            nowyKlient.setImie(inputImie.getText());
            nowyKlient.setNazwisko(inputNazwisko.getText());
            nowyKlient.setPesel(inputPesel.getText());
            nowyKlient.setSumaPkt(0);
            
            klientRepository.save(nowyKlient);
            
            inputHaslo.setText("");
            inputLogin.setText("");
            inputDowod.setText("");
            inputImie.setText("");
            inputNazwisko.setText("");
            inputPesel.setText("");
            inputPowtorzHaslo.setText("");
        }
    }
    
    private boolean validateAllFields() {
        return validateImie() && validateNazwisko() && validatePesel() && validateDowod() && validateLogin()
                && validateHaslo() && validatePowtorzHaslo() && validatePeselExists() && validateDowodExists()
                && validateLoginExists();
    }
    
    @FXML
    public boolean validatePowtorzHaslo() {
        boolean verified = inputNotEmpty(inputPowtorzHaslo) && inputPowtorzHaslo.getText().equals(inputHaslo.getText());
        addOrRemoveBadInput(inputPowtorzHaslo, verified);
        return verified;
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
    
    private boolean validateLoginExists() {
        boolean verified = !klientRepository.isClientByLoginExists(inputLogin.getText());
        addOrRemoveBadInput(inputLogin, verified);
        return verified;
    }
    
    @FXML
    public boolean validateDowod() {
        limitText(inputDowod, 9);
        boolean verified = inputNotEmpty(inputDowod) 
                && Pattern.compile("^[A-Z]{3}[0-9]{6}").matcher(inputDowod.getText()).matches();
        addOrRemoveBadInput(inputDowod, verified);
        return verified;
    }

    private void limitText(TextField input, int limit) {
        if (input.getText().length() > limit) {
            input.setText(input.getText().substring(0, limit));
            input.positionCaret(limit);
        }
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
        limitText(inputPesel, 11);
        boolean verified = inputNotEmpty(inputPesel)
                && Pattern.compile("[0-9]{4}[0-3]{1}[0-9]{1}[0-9]{5}").matcher(inputPesel.getText()).matches()
                && sprawdzSumeKontrolna(inputPesel.getText());
        addOrRemoveBadInput(inputPesel, verified);
        return verified;
    }
    
    private boolean sprawdzSumeKontrolna(String pesel) {
        final int[] iloczyny = {9,7,3,1,9,7,3,1,9,7};
        
        Integer suma = 0;
        for (int i = 0; i<10; i++) {
            suma += iloczyny[i] * Integer.parseInt(pesel.charAt(i)+"");
        }
        return suma%10 == Integer.parseInt(pesel.charAt(10)+"");
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
}
