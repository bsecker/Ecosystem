/**
 * Created by Benjamin on 13-Jul-17.
 * Test object.
 */
import ecs100.*;
import java.awt.*;

public class Fly extends Entity {

    double topSpeed;
    double size;
    double accel;

    public Fly(double x, double y) {
        super(x, y);

        this.location = new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0);

        this.topSpeed = 2;
        this.size = 5;
        this.mass = 1;
    }

    public void update() {

        // apply random force to simulate random movement
        PVector random_dir = PVector.random2d();
        random_dir.mult(0.2);
        this.applyForce(random_dir);

        // update resulting velocity and position vectors
        this.velocity.add(this.acceleration);
        this.velocity.limit(this.topSpeed); // limit velocity
        this.location.add(this.velocity);

        // clear accelleration for each frame
        acceleration.mult(0);

    }

    public void draw() {
        UI.setColor(this.color);
        UI.drawOval(location.getX() - size/2, location.getY() - size/2 , size, size);
    }

}
