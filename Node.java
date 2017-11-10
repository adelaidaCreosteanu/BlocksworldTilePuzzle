import java.util.ArrayList;
import java.util.Collections;

// Used by blind search
public class Node {
    protected Node parent;
    protected int depth;
    protected Board boardState;

    public Node(Node parent, int depth, Board state) {
        this.parent = parent;
        this.depth = depth;
        this.boardState = state;
    }

    public ArrayList<Node> getSuccessors(boolean randomise) {
        ArrayList<Node> list = new ArrayList<>(4);
        int x = boardState.getAgentX();
        int y = boardState.getAgentY();


        for (Position newP : getPositions(x, y, randomise)) {
            if (boardState.isLegal(newP.x, newP.y)) {
                Board b = new Board(boardState.cloneState(), x, y);
                b.moveAgent(newP.x, newP.y);               //update the state
                list.add(new Node(this, depth + 1, b));
            }
        }

        return list;
    }

    /*
         * Puts the four neighbours of the coordinates received as arguments in a list and returns
         * the shuffled list. The returned list can contain illegal positions (outside the board)
         * but this is dealt with in the Board class
         */
    protected ArrayList<Position> getPositions(int x, int y, boolean randomise) {
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
