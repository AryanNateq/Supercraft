package supercraftPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Supercraft");

        Group group = new Group();
        Scene scene = new Scene(group, 1280, 720);
        initGame(group, scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initGame(Group group, Scene scene) {
        Block block = new Block(500, 500, 500);

        Player player = new Player(true);
        player.setTranslateZ(-1000);
        player.setNearClip(0.1);
        player.setFarClip(2000.0);
        player.setFieldOfView(100);
        player.setTranslateX(500);
        player.setTranslateY(300);
        group.getChildren().addAll(block, player);
        scene.setCamera(player);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
