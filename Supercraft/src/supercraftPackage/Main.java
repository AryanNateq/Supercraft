package supercraftPackage;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Supercraft");

        Group group = new Group();
        Scene scene = new Scene(group, 1280, 720, true, SceneAntialiasing.BALANCED);
        initGame(group, scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initGame(Group group, Scene scene) {
        Block block = new Block(500, 500, 500);
        block.setMaterial(new PhongMaterial(Color.RED));
        Block plane = new Block(3000, 50, 3000);
        plane.setLayoutY(500);

        Player player = new Player(true, scene);
        player.setTranslateZ(-1000);
        player.setTranslateX(500);
        player.setTranslateY(300);
        player.setNearClip(0.1);
        player.setFarClip(100000); // View distance.
        player.setFieldOfView(42);
        player.setVerticalFieldOfView(true);
        //player.setRotationAxis(new Point3D(1, 0, 0));
        //player.setRotate(-25); // Rotates on the x axis (up/down).
        group.getChildren().addAll(block, plane, player);
        scene.setCamera(player);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
