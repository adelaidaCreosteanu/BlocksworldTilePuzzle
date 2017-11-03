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

        for(int maxDepth = 0; !end; maxDepth ++) {
            depthLimitedSearch(maxDepth);
        }
        return nodesExpanded;
    }

    private void depthLimitedSearch(int maxDepth) {
        while (!fringe.empty()) {
            Node current = fringe.pop();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("~~~~~\nIDS found a solution at depth: " + current.depth);
                System.out.println("Number of nodes expanded: " + nodesExpanded);
                b.printState();
                end = true;
            } else {
                for (Node node : current.getSuccessors(false)) {
                    fringe.push(node);
                }
            }

            if (current.depth == maxDepth) {
                break;
            }
        }
    }
}
