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

        for (int maxDepth = 0; !end; maxDepth++) {
            recursiveDLS(root, maxDepth);
        }

        System.out.println("~~~~\nIDSearch expanded: " + nodesExpanded + " nodes");
        return nodesExpanded;
    }

    private Node recursiveDLS(Node current, int maxDepth) {
        nodesExpanded++;


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
