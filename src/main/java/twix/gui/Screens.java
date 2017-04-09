package twix.gui;

import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import twix.Main;

@Service
public class Screens {

    private Stage stage;
    private Scene scene;
    private StackPane root;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public Stage getStage() {
        return stage;
    }
    
    public void showMainScreen() {
        root = new StackPane();
        root.getStylesheets().add("main.css");
        root.getStyleClass().add("main-window");
        stage.setTitle("SpringFX");
        scene = new Scene(root, 710, 530);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        stage.show();
    }

    private void setNode(Node node) {
        root.getChildren().setAll(node);
    }

    public void removeNode(Node node) {
        root.getChildren().remove(node);
    }
    
    private Node getNode(final Presentation control, URL location) {
        FXMLLoader loader = new FXMLLoader(location);
        loader.setControllerFactory(clazz -> Main.context.getBean(clazz));

        try {
            return (Node) loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public void loadMainScreen() {
        loadScreen(mainScreen(), "/gui/mainScreen.fxml");
    }
    
    public void loadRegisterScreen() {
        loadScreen(registerScreen(), "/gui/register.fxml");
    }
    
    public void loadLoginScreen() {
        loadScreen(loginScreen(), "/gui/login.fxml");
    }
    
    public void loadUserMainScreen() {
        loadScreen(userMainScreen(), "/gui/userPanel.fxml");
    }
    
    public void loadRankingScreen() {
        loadScreen(rankingScreen(), "/gui/ranking.fxml");
    }
    
    public void loadUserCostsScreen() {
        loadScreen(userCostsScreen(), "/gui/userCosts.fxml");
    }
    
    public void loadUserStatsScreen() {
        loadScreen(userStatsScreen(), "/gui/userStats.fxml");
    }
    
    public void loadAdminMainScreen() {
        loadScreen(adminMainScreen(), "/gui/adminPanel.fxml");
    }
    
    public void loadAdminDeleteScreen() {
        loadScreen(adminDeleteUserScreen(), "/gui/adminDeleteUser.fxml");
    }
    
    public void loadAdminEditUserScreen() {
        loadScreen(adminEditUserScreen(), "/gui/adminUserEdit.fxml");
    }
    
    public void loadAdminAddScoreScreen() {
        loadScreen(adminAddScoreScreen(), "/gui/adminAddScore.fxml");
    }
    
    public void loadUserRezerwacjaScreen() {
        loadScreen(userRezerwacjaScreen(), "/gui/userRezerwacja.fxml");
    }
    
    public void loadAdminRezerwacjeScreen() {
        loadScreen(adminRezerwacjeScreen(), "/gui/adminRezerwacje.fxml");
    }
    
    private void loadScreen(Presentation control, String resource) {
        setNode(getNode(control, getClass().getResource(resource)));
    }

    @Bean
    AdminRezerwacjeScreen adminRezerwacjeScreen() {
        return new AdminRezerwacjeScreen(this);
    }
    
    @Bean
    UserRezerwacjaScreen userRezerwacjaScreen() {
        return new UserRezerwacjaScreen(this);
    }
    
    @Bean
    AdminAddScoreScreen adminAddScoreScreen() {
        return new AdminAddScoreScreen(this);
    }
    
    @Bean
    AdminEditUserScreen adminEditUserScreen() {
        return new AdminEditUserScreen(this);
    }
    
    @Bean
    AdminDeleteUserScreen adminDeleteUserScreen() {
        return new AdminDeleteUserScreen(this);
    }
    
    @Bean
    AdminMainScreen adminMainScreen() {
        return new AdminMainScreen(this);
    }
    
    @Bean
    UserStatsScreen userStatsScreen() {
        return new UserStatsScreen(this);
    }
    
    @Bean
    UserCostsScreen userCostsScreen() {
        return new UserCostsScreen(this);
    }
    
    @Bean
    RankingScreen rankingScreen() {
        return new RankingScreen(this);
    }

    @Bean
    MainScreen mainScreen() {
        return new MainScreen(this);
    }
    
    @Bean
    RegisterScreen registerScreen() {
        return new RegisterScreen(this);
    }
    
    @Bean
    LoginScreen loginScreen() {
        return new LoginScreen(this);
    }
    
    @Bean
    UserMainScreen userMainScreen() {
        return new UserMainScreen(this);
    }
    
}
