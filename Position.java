import java.util.ArrayList;
import java.util.Collections;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* Can contain illegal positions (out of board bounds) but this is handled
     * in the Board class in the isLegal(x,y) method.
     */
    public ArrayList<Position> getAdjacent(boolean randomise) {
        ArrayList<Position> p = new ArrayList<>(4);

        p.add(new Position(x - 1, y));
        p.add(new Position(x + 1, y));
        p.add(new Position(x, y - 1));
        p.add(new Position(x, y + 1));

        if (randomise) {
            Collections.shuffle(p);
        }

        return p;
    }
}
