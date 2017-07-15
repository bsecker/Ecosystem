/**
 * Created by Benjamin on 15-Jul-17.
 * Player controlled fish
 */
public class Player extends Fish{
    public Player(double x, double y) {
        super(x, y);

    }

    public void seek(PVector target) {
        PVector desired = PVector.sub(target,location);

        desired.normalise();
        desired.mult(topSpeed);

        // Reynolds’s formula for steering force
        PVector steer = PVector.sub(desired,velocity);

        steer.limit(maxforce); // limit steering magnitude

        // Using our physics model and applying the force
        // to the object’s acceleration
        applyForce(steer);
    }

}
