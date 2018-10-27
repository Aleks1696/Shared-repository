package javafx.homework2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Contacts information");

        Parent parent = FXMLLoader.load(
                getClass().getResource("/javafx/homework2/main.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
