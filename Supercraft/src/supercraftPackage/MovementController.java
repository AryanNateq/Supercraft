package supercraftPackage;

import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MovementController extends PerspectiveCamera {
    private final double MOVEMENT_RATE = 10;

    public MovementController(boolean fixedEyeAtCameraZero, Scene scene) {
        super(fixedEyeAtCameraZero);
        init(scene);
    }


    private void init(Scene scene) {
        createKeyboardHandler(scene);
    }

    private void createKeyboardHandler(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                processKeyPress(event.getText());
            }
        });
    }

    private void processKeyPress(String key) {
        switch(key) {
            case "w":
                handleW();
                break;
            case "a":
                handleA();
                break;
            case "s":
                handleS();
                break;
            case "d":
                handleD();
                break;
        }
    }

    private void handleW() {
        this.setTranslateZ(this.getTranslateZ() + MOVEMENT_RATE);
    }

    private void handleA() {
        this.setTranslateX(this.getTranslateX() - MOVEMENT_RATE);
    }

    private void handleS() {
        this.setTranslateZ(this.getTranslateZ() - MOVEMENT_RATE);
    }

    private void handleD() {
        this.setTranslateX(this.getTranslateX() + MOVEMENT_RATE);
    }
}
