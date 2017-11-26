import java.util.Stack;

// This class implements iterative deepening search
public class IDSearch {
    private Stack<Node> fringe;
    private boolean end;
    private int nodesExpanded;

    public IDSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new Stack<>();
        fringe.push(new Node(null, 0, initial));
    }

    public int go() {
        end = false;
        nodesExpanded = 0;
        Node current = null;

        for (int maxDepth = 0; !end; maxDepth++) {
            current = depthLimitedSearch(maxDepth);
        }

        // Print path to goal
        System.out.println("~~~~\nIDSearch expanded: " + nodesExpanded + " nodes");
//        current.printPath();
        return nodesExpanded;
    }

    private Node depthLimitedSearch(int maxDepth) {
        Node current = fringe.pop();

        while (current.depth <= maxDepth) {
            nodesExpanded++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                end = true;
                return current;
            } else {
                fringe.addAll(current.getSuccessors(true));
            }

            current = fringe.pop();
        }
        return null;
    }
}
