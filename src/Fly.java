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

    public Fly(float x, float y) {
        this.location = new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(-4, 2);

        this.topSpeed = 8;
        this.size = 10;
        this.accel = 4;
    }

    public void update() {
        this.acceleration = PVector.random2d();
        this.acceleration.mult(accel);

        this.velocity.add(this.acceleration);
        this.velocity.limit(this.topSpeed);
        this.location.add(this.velocity);

    }

    public void draw() {
        UI.setColor(Color.black);
        UI.drawOval(location.getX() - size/2, location.getY() - size/2 , size, size);
    }

}
