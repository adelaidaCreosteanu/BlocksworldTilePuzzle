public class IDSearch {
    private boolean end;
    private int nodesExpanded;
    private Node root;

    public IDSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        root = new Node(null, 0, initial);
    }

    public int go() {
        end = false;
        nodesExpanded = 0;
        Node current = null;

        for (int maxDepth = 0; !end; maxDepth++) {
            current = recursiveDLS(root, maxDepth);
        }

        // Print path to goal
        System.out.println("~~~~\nIDSearch expanded: " + nodesExpanded + " nodes");
//        current.printPath();
        return nodesExpanded;
    }

    private Node recursiveDLS(Node current, int maxDepth) {
        nodesExpanded++;

        // Print statements to see order of node expansion
        System.out.println("Depth: " + current.depth);
        current.boardState.printState();
        System.out.println();

        if (current.boardState.isGoalState()) {
            end = true;
            return current;
        } else if (current.depth == maxDepth) {
            return null;
        } else {
            for (Node n : current.getSuccessors(true)) {
                Node result = recursiveDLS(n, maxDepth);
                if (result == null) {
                    return null;
                } else {
                    return result;
                }
            }
        }
        return null;
    }
}
