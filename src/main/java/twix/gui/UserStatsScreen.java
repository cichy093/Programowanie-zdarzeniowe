package twix.gui;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import twix.database.TwixWyniki;
import twix.login.Login;
import twix.repository.RankingRepository;

public class UserStatsScreen extends Presentation {

    @Autowired
    RankingRepository rankingRepository;
    
    public UserStatsScreen(Screens screens) {
        super(screens);
    }

    @FXML
    ListView<TwixWyniki> listViewLast;
    
    @FXML
    ListView<TwixWyniki> listViewBest;
    
    @FXML
    public void gotoUserMainScreen(ActionEvent event) {
        config.loadUserMainScreen();
    }
    
    @FXML
    public void initialize() {
        List<TwixWyniki> list = rankingRepository.getLoginWyniki(Login.getZalogowanyUzytkownik().getLogin());
        
        ObservableList<TwixWyniki> items = FXCollections.observableList(list);
        ObservableList<TwixWyniki> items2 = FXCollections.observableList(
                list.stream().sorted((e1, e2) -> e2.getWynik().compareTo(e1.getWynik()))
                .collect(Collectors.toList()));

        listViewLast.setItems(items);
        listViewBest.setItems(items2);
    }
}
