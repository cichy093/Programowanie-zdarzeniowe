package twix.gui;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import twix.database.TwixWyniki;
import twix.repository.RankingRepository;

public class RankingScreen extends Presentation {

    @Autowired
    RankingRepository rankingRepository;
    
    public RankingScreen(Screens screens) {
        super(screens);
    }
    
    @FXML
    ListView<TwixWyniki> listViewRanking;
    
    @FXML
    public void gotoUserMainScreen(ActionEvent event) {
        config.loadUserMainScreen();
    }
    
    @FXML
    public void initialize() {
        ObservableList<TwixWyniki> items = 
                FXCollections.observableList(
                        rankingRepository.getAllWyniki());
        listViewRanking.setItems(items);
    }
}
