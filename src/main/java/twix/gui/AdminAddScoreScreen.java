package twix.gui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import twix.database.TwixKlienci;
import twix.database.TwixSLBroni;
import twix.database.TwixWyniki;
import twix.repository.BronRepository;
import twix.repository.KlientRepository;
import twix.repository.RankingRepository;

public class AdminAddScoreScreen extends Presentation {

    public AdminAddScoreScreen(Screens screens) {
        super(screens);
    }

    @Autowired
    BronRepository bronRepository;
    
    @FXML
    TextField inputSearchLogin;
    
    @FXML
    ComboBox<TwixSLBroni> comboBron;
    
    @FXML
    TextField inputWynik;
    
    @Autowired
    private KlientRepository klientRepository;
    
    @Autowired
    private RankingRepository rankingRepository;
    
    private TwixKlienci tk;

    @FXML
    public void dodaj(ActionEvent event) {
        if (!validateLoginExists() || !validateScore() || !validateComboBron())
            return;
        
        TwixWyniki tw = new TwixWyniki();
        tw.setData(new Date());
        tw.setIdKlienta(tk.getId());
        tw.setWynik(Integer.valueOf(inputWynik.getText()));
        tw.setId(rankingRepository.getMaxId()+1);
        
        rankingRepository.save(tw);
        
        tk.setSumaPkt(tk.getSumaPkt() + Integer.valueOf(inputWynik.getText()));
        tk.setIdRangi((int) Math.ceil(tk.getSumaPkt()/200)+1);
        klientRepository.save(tk);
        
        tk = null;
        inputWynik.setText("");
        inputSearchLogin.setText("");
    }
    
    public boolean validateComboBron() {
        boolean verified = comboBron.getValue() != null;
        addOrRemoveBadInput(comboBron, verified);
        return verified;
    }
    
    public boolean validateScore() {
        boolean verified = inputNotEmpty(inputWynik);
        addOrRemoveBadInput(inputWynik, verified);
        return verified;
    }
    
    private boolean validateLoginExists() {
        tk = klientRepository.getByLogin(inputSearchLogin.getText());
        boolean verified = tk != null;
        addOrRemoveBadInput(inputSearchLogin, verified);
        return verified;
    }

    private boolean inputNotEmpty(TextField tf) {
        return !tf.getText().isEmpty();
    }
    
    private void addOrRemoveBadInput(Control tf, boolean verified) {
        if (!verified && !tf.getStyleClass().contains("badInput")) {
            tf.getStyleClass().add("badInput");
        } else if (verified) {
            tf.getStyleClass().remove("badInput");
        }
    }

    @FXML
    public void gotoAdminMainScreen(ActionEvent event) {
        config.loadAdminMainScreen();
    }
    
    @FXML
    public void initialize() {
        comboBron.setItems(FXCollections.observableList(
                bronRepository.getBron()));
    }
}
