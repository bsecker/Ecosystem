import ecs100.UI;
import java.awt.*;

/**
 * Created by Benjamin on 15-Jul-17.
 */
public class Fish extends Entity{
    double maxforce; // maximum "turning speed"
    private double angle;

    public Fish(double x, double y) {
        super(x, y);

        this.topSpeed = 2;
        this.size = 10;
        this.mass = 1;
        this.color = Color.BLUE;
        this.maxforce = 0.01875;
        this.angle = 0;
    }

    public void update() {
        // update angle
        this.angle = Math.atan2(velocity.getY(),velocity.getX());

        // update rest
        super.update();



    }

    public void draw() {

        // draw triangle rotated
        UI.setColor(this.color);
        UI.drawLine(this.location.getX(), this.location.getY(),
                this.location.getX() + Math.cos(this.angle)*(size/2), this.location.getY()+ Math.sin(this.angle)*(size/2));
        UI.drawOval(location.getX() - size/2, location.getY() - size/2 , size, size);
    }

}
