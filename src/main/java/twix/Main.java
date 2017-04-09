package twix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import twix.gui.Screens;

@Service
public class Main extends Application {
    
    public static final ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {

        Platform.setImplicitExit(true);

        Screens screens = context.getBean(Screens.class);
        
        screens.setPrimaryStage(stage);
        screens.showMainScreen();
        screens.loadMainScreen();
    }
}
