import java.util.ArrayDeque;

public class IDSearch {
    private ArrayDeque<Node> fringe;    // used as LIFO
    private boolean end;
    private int nodesExpanded;

    public IDSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new ArrayDeque<>();
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

            // Print statements to see order of node expansion
            System.out.println("Depth: " + current.depth);
            current.boardState.printState();
            System.out.println();

            if (current.boardState.isGoalState()) {
                end = true;
                return current;
            } else {
                for (Node n : current.getSuccessors(true)) {
                    fringe.push(n);
                }
            }

            current = fringe.pop();
        }
        System.out.println("Stopped");
        return null;
    }
}
