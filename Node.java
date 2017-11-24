import java.util.ArrayList;

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
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(randomise)) {
            if (boardState.isLegal(newP.x, newP.y)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP.x, newP.y);
                list.add(new Node(this, depth + 1, b));
            }
        }

        return list;
    }
}
