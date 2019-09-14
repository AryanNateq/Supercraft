package supercraftPackage;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;

public class MovementController extends PerspectiveCamera {

    public MovementController(boolean fixedEyeAtCameraZero, Scene scene) {
        super(fixedEyeAtCameraZero);
        init(scene);
    }

    private void init(Scene scene) {
        scene.setOnKeyPressed(new KeyboardHandler(this));
        scene.setOnMouseMoved(new MouseLook(this));
    }
}

