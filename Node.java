import java.util.ArrayList;
import java.util.Collections;

public class Node {
    protected Node parent;
    protected int depth;        // Do I really need depth?
    protected Board boardState;
    protected int cost;       // Not sure about this

    public Node(Node parent, int depth, Board state) {
        this.parent = parent;
        this.depth = depth;
        this.boardState = state;
    }

    public ArrayList<Node> getSuccessors() {
        ArrayList<Node> list = new ArrayList<>(4);
        int x = boardState.getAgentX();
        int y = boardState.getAgentY();

        for (Position newP : getRandomisedPositions(x, y)) {
            if (boardState.isLegal(newP.x, newP.y)) {
                Board b = new Board(boardState.getState(), x, y);
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
    protected ArrayList<Position> getRandomisedPositions(int x, int y) {
        ArrayList<Position> p = new ArrayList<>(4);

        p.add(new Position(x - 1, y));
        p.add(new Position(x, y + 1));
        p.add(new Position(x + 1, y));
        p.add(new Position(x, y - 1));

        Collections.shuffle(p);

        return p;
    }
}
