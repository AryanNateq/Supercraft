package supercraftPackage;

import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler  implements EventHandler<KeyEvent> {
    private PerspectiveCamera camera;
    private final double MOVEMENT_RATE = 10;

    public KeyboardHandler(PerspectiveCamera camera) {
        this.camera = camera;
    }

    @Override
    public void handle(KeyEvent event) {
        processKeyPress(event.getText());
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
        camera.setTranslateZ(camera.getTranslateZ() + MOVEMENT_RATE);
    }

    private void handleA() {
        camera.setTranslateX(camera.getTranslateX() - MOVEMENT_RATE);
    }

    private void handleS() {
        camera.setTranslateZ(camera.getTranslateZ() - MOVEMENT_RATE);
    }

    private void handleD() {
        camera.setTranslateX(camera.getTranslateX() + MOVEMENT_RATE);
    }
}
