/**
 * Created by Benjamin on 14/07/2017.
 * Base class for every object*/


public class Entity {
    protected PVector location;
    protected PVector velocity;
    protected PVector acceleration;
    protected double mass;

    public Entity () {
        ;
    }

    // apply newtons second law
    public void applyForce(PVector force) {
        force.div(mass);
        acceleration.add(force);
    }

    public void update() {

        // clear accelleration for each frame
        acceleration.mult(0);

    }

    public void draw() {

    }


}
