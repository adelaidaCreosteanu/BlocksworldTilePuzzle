import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

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
            Board b = boardState.cloneBoard();
            // Update agent position:
            b.moveAgent(newP.x, newP.y);
            list.add(new Node(this, depth + 1, b));
        }

        return list;
    }

    public void printPath() {
        ArrayDeque<Node> path = new ArrayDeque<>();
        Node current = this;

        while (current != null) {
            path.add(current);
            current = current.parent;
        }

        Iterator<Node> it = path.descendingIterator();

        while (it.hasNext()) {
            Node n = it.next();
            System.out.println("Depth: " + n.depth);
            n.boardState.printState();
            System.out.println();
        }
    }
}
