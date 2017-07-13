import sun.util.resources.cldr.naq.CalendarData_naq_NA;

/**
 * Created by Benjamin on 13-Jul-17.
 * Used primarily for making games, but can be applicable anywhere (I use it to help with homework :D)
 */
public class PVector {
    /** Physics Vector Class. */
    private float x;
    private float y;

    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Perform vector addition with another vector v.
     * @param v
     */
    public void add(PVector v) {
        this.x += v.getX();
        this.y += v.getY();
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
     * Multiply vector by scalar n.
     * @param n
     */
    public void mult(float n) {
        this.x *= n;
        this.y *= n;
    }

    /**
     * divide vector by scalar n.
     * @param n
     */
    public void div(float n) {
        this.x = this.x / n;
        this.y = this.y / n;
    }

    /**
     * return magnitude of current vector
     * @return
     */
    public float mag() {
        return (float) Math.sqrt((float)Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Normalise the vector
     */
    public void normalise() {
        float _mag = mag();
        if (_mag!= 0) div(_mag);
    }

    public void limit() {
        ;
    }

    public void heading() {
        ;
    }





    public float getY() {
        return y;
    }

    public float getX() {
        return x;

    }

    public String toString() {
        return x + " " + y;
    }
}
