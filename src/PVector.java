import java.util.Random;

/**
 * Created by Benjamin on 13-Jul-17.
 * Used primarily for making games, but can be applicable anywhere (I use it to help with homework :D)
 */
public class PVector {
    /** Physics Vector Class. */
    private double x;
    private double y;

    public PVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Perform vector addition with another vector v.
     * @param v
     * @return current object
     */
    public void add(PVector v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    /**
     * Return new vector as addition of two vectors v and u
     */
    public PVector add(PVector v, PVector u) {
        return new PVector(v.getX() + u.getX(), v.getY() + u.getY());

    }
    /**
     * Perform vector subraction with another vector v.
     * @param v
     */
    public void sub(PVector v) {
        this.x +=- v.getX();
        this.y +=- v.getY();
    }



    /**
     * Return new vector as subtraction of two vectors u and v
     */

    public static PVector sub(PVector v, PVector u) {
        return new PVector(v.getX() - u.getX(), v.getY() - u.getY());
    }

    /**
     * Multiply vector by scalar n.
     * @param n
     */
    public void mult(double n) {
        this.x *= n;
        this.y *= n;
    }

    /**
     * divide vector by scalar n.
     * @param n
     */
    public void div(double n) {
        this.x = this.x / n;
        this.y = this.y / n;
    }

    /**
     * return magnitude of current vector
     * @return
     */
    public double mag() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Normalise the vector
     */
    public void normalise() {
        double _mag = mag();
        if (_mag!= 0) div(_mag);
    }

    /**
     * constrain vector magnitude to m
     */
    public void limit(double m) {
        if (mag() > m) {
            normalise();
            mult(m);
        }
    }

    public void heading() {
        ;
    }

    /**
     * Return new PVector class as a copy of the current vector
     * @return
     */
    public PVector get() {
        return new PVector(this.getX(), this.getY());
    }

    /**
     * return unit vector in random direction.
     */
    public static PVector random2d() {
        PVector v = new PVector(Math.random()*2 - 1, Math.random()*2 - 1);
        v.normalise();
        return v;
    }


    /** --------------MISC FUNCTIONS-------------- */

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return x + " " + y;
    }
}
