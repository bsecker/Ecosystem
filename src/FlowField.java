/**
 * Created by Benjamin on 16-Jul-17.
 */
public class FlowField {
    private static PVector[][] field;
    private static int cols;
    private static int rows;
    private static int resolution;

    public FlowField() {
        cols = (int) (Ecosystem.RIGHT-Ecosystem.LEFT/resolution);
        rows = (int) (Ecosystem.BOTTOM-Ecosystem.TOP/resolution);
        field = new PVector[cols][rows];


        // set data of field
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                field[i][j] = PVector.random2d();
            }
        }
    }

    public PVector lookup(PVector lookup) {
        int column = (int) (lookup.getX()/resolution);
        int row = (int) (lookup.getY()/resolution);

        // constrain
        if (column < 0) column = 0;
        if (column > cols-1) column = cols-1;
        if (row < 0) row = 0;
        if (row > rows-1) row = rows-1;


        // Note the use of get() to ensure
        // we return a copy of the PVector.
        return field[column][row].get();
    }
}
