package twix.gui;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import twix.database.TwixRezerwacja;
import twix.repository.RezerwacjaRepository;

public class AdminRezerwacjeScreen extends Presentation {
    
    public AdminRezerwacjeScreen(Screens screens) {
        super(screens);
    }
    
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;
    
    @FXML
    DatePicker datepicker;
    
    @FXML
    TextField inputLogin;
    
    @FXML
    ListView<TwixRezerwacja> listViewRezerwacje;

    private List<TwixRezerwacja> rezerwacje;
    private ObservableList<TwixRezerwacja> obs;
    
    @FXML
    public void gotoAdminMainScreen(ActionEvent event) {
        config.loadAdminMainScreen();
    }

    @FXML
    public void filter() {
        Stream<TwixRezerwacja> filtered = rezerwacje.stream();
        
        if (datepicker.getValue() != null) {
            filtered = filtered.filter(e -> e.getData().toString().substring(0, 10).equals(new SimpleDateFormat("yyyy-MM-dd").format(selectedDate())));
        }
        if (inputLogin.getText() != "") {
            filtered = filtered.filter(e -> e.getKlient().getLogin().contains(inputLogin.getText()));
        }
        filtered = filtered.filter(e -> e.getData().compareTo(new Date()) >= 0);
        

        
        filtered = filtered.sorted(Comparator.comparing(TwixRezerwacja::getData)
                .thenComparing(TwixRezerwacja::getCzas)
                .thenComparing(TwixRezerwacja::getIdToru));
        
        obs = FXCollections.observableList(filtered.collect(Collectors.toList()));
        listViewRezerwacje.setItems(obs);
    }
    
    private Date selectedDate() {
        return Date.from(datepicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());    
    }
    
    @FXML
    public void initialize() {
        rezerwacje = rezerwacjaRepository.getAll();
        filter();
    }
    

}
