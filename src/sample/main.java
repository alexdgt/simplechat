package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 275, 400));

        ChatClient client = new ChatClient(controller);
        controller.setClient(client);

        client.go();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
