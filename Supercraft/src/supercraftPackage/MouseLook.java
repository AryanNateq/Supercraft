package supercraftPackage;

import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

class MouseLook implements EventHandler<MouseEvent> {
    private PerspectiveCamera camera;
    private static Rotate rotation;
    private static int oldX, newX;
    private static boolean alreadyMoved = false;

    public MouseLook(PerspectiveCamera camera) {
        this.camera = camera;
    }

    @Override
    public void handle(MouseEvent event) {
        if ( alreadyMoved ) {
            newX = (int) event.getScreenX();

            if ( oldX < newX ) { // if mouse moved to right
                rotation = new Rotate(2.0,
                        // camera rotates around its location
                        camera.getTranslateX(), camera.getTranslateY(), camera.getTranslateZ(),
                        Rotate.Y_AXIS);

            } else if ( oldX > newX ) { // if mouse moved to left
                rotation = new Rotate(-2.0,
                        // camera rotates around its location
                        camera.getTranslateX(), camera.getTranslateY(), camera.getTranslateZ(),
                        Rotate.Y_AXIS);
            }
            camera.getTransforms().addAll(rotation);
            oldX = newX;
        } else {
            oldX = (int) event.getScreenX();
            alreadyMoved = true;
        }
    }
}