package supercraftPackage;

import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.util.Callback;

class MouseLook implements EventHandler<MouseEvent> {
    private PerspectiveCamera camera;
    private final Translate t = new Translate(0, 0, 0);
    private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS),
            rotateY = new Rotate(0, Rotate.Y_AXIS);
    private double mousePosX;
    private double mouseOldX;
    private double mousePosY;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;

    public MouseLook(PerspectiveCamera camera) {
        this.camera = camera;
    }
    private final Callback<Transform, Point3D> P = (a) -> {
        return new Point3D(a.getTx(), a.getTy(), a.getTz());
    };

    public final Point3D getPosition() {
        return P.call(camera.getLocalToSceneTransform());
    }

    public static float clamp(float input, float min, float max) {
        return (input < min) ? min : (input > max) ? max : input;
    }

    @Override
    public void handle(MouseEvent me) {
        mouseOldX = mousePosX;
        mouseOldY = mousePosY;
        mousePosX = me.getSceneX();
        mousePosY = me.getSceneY();
        mouseDeltaX = (mousePosX - mouseOldX);
        mouseDeltaY = (mousePosY - mouseOldY);


        t.setX(getPosition().getX());
        t.setY(getPosition().getY());
        t.setZ(getPosition().getZ());

        if ( mouseOldX < mousePosX ) { // if mouse moved to right
            rotateY.setAngle(rotateY.getAngle() + 1.0 * 0.005);
        } else if ( mouseOldX > mousePosX ) { // if mouse moved to left
            rotateY.setAngle(rotateY.getAngle() - 1.0 * 0.005);
        }
        if ( mouseOldY < mousePosY ) { // if mouse moved to right
            rotateX.setAngle(rotateX.getAngle() - 1.0 * 0.005);
        } else if ( mouseOldY > mousePosY ) { // if mouse moved to left
            rotateX.setAngle(rotateX.getAngle() + 1.0 * 0.005);
        }

        camera.getTransforms().addAll(rotateY, rotateX);
    }
}