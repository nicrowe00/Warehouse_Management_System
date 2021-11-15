package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    static LinkedLists<Floor> floorLinkedLists = new LinkedLists<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("warehouse.fxml"));
        primaryStage.setTitle("Warehouse Inventory System");
        primaryStage.setScene(new Scene(root, 1123, 672));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}