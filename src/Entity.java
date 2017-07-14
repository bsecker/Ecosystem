import java.awt.*;

/**
 * Created by Benjamin on 14/07/2017.
 * Base class for every object*/


public class Entity {
    // vectors
    protected PVector location;
    protected PVector velocity;
    protected PVector acceleration;

    // scalars
    protected double mass;
    protected double size;
    protected double topSpeed;
    protected Color color;

    protected double attract_strength;
    protected double repel_strength;

    public Entity (double x, double y) {
        this.location = new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0);

        this.topSpeed = 5;
        this.size = 20;
        this.mass = 1.2;
        this.color = Color.BLACK;

        attract_strength = 5;
        repel_strength = 15;
    }

    // apply newtons second law
    public void applyForce(PVector force) {
        force.div(mass);
        acceleration.add(force);
    }


    /**
     * Attract Entity m towards self.
     * @param m
     * @return PVector of attraction
     */
    public PVector attract(Entity m) {
        // get force direction
        PVector force = PVector.sub(this.location, m.location);
        double distance = force.mag();
        force.normalise();

        // get force magnitude
        double min_dist = 5; // constrain minimum distance

        if (distance < min_dist) distance = min_dist;
        double strength = (attract_strength * this.mass * m.mass) / Math.pow(distance, 2);
        force.mult(strength);

        // return new force
        return force;
    }

    /**
     * Repel entity m away from self.
     * @param m
     * @return repelling PVector
     */
    public PVector repel(Entity m) {
        PVector dir = PVector.sub(location,m.location);
        double d = dir.mag();
        dir.normalise();

        // constrain
        if (d < 5) d = 5;
        if (d > 100) d = 100;

        // find force
        double force = -1 * repel_strength / (d * d);
        dir.mult(force);
        return dir;
    }

    public void update() {

        // update resulting velocity and position vectors
        this.velocity.add(this.acceleration);
        this.velocity.limit(this.topSpeed); // limit velocity
        this.location.add(this.velocity);

        // clear accelleration for each frame
        acceleration.mult(0);

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw() {

    }

    // default action is to wrap edges of screen.
    public void check_edges() {
        if (this.location.getX() > Ecosystem.RIGHT) {
            location.setX(Ecosystem.LEFT);
        }
        else if (this.location.getX() < Ecosystem.LEFT) {
            location.setX(Ecosystem.RIGHT);
        }
        if (location.getY() > Ecosystem.BOTTOM) {
            location.setY(Ecosystem.TOP);
        }
        else if (location.getY() < Ecosystem.TOP) {
            location.setY(Ecosystem.BOTTOM);
        }
    }


}
