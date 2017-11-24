import java.util.ArrayList;
import java.util.Collections;

public class Position {
    public final int x;     // cannot be modified
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //TODO: update comment
    /*
     * Puts the four neighbours of the coordinates received as arguments in a list and returns
     * the shuffled list. The returned list can contain illegal positions (outside the board)
     * but this is dealt with in the Board class
     */
    public ArrayList<Position> getAdjacent(boolean randomise) {
        ArrayList<Position> p = new ArrayList<>(4);

        p.add(new Position(x - 1, y));
        p.add(new Position(x, y + 1));
        p.add(new Position(x + 1, y));
        p.add(new Position(x, y - 1));

        if (randomise) {
            Collections.shuffle(p);
        }

        return p;
    }
}
