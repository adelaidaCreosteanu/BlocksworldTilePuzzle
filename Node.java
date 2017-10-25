import java.util.ArrayList;

public abstract class Node {
    protected Node parent;
    protected int depth;
    protected Board boardState;
    protected int cost;       // Not sure about this

    public Node(Node parent, int depth, Board state) {
        this.parent = parent;
        this.depth = depth;
        this.boardState = state;
    }

    public abstract ArrayList<Node> getSuccessors();
}
