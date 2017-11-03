import java.util.Stack;

// This class implements Depth-first tree search
public class DFSearch {
    private Stack<Node> fringe;

    public DFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new Stack<>();
        fringe.push(new Node(null, 0, initial));
    }

    public int go() {
        boolean end = false;
        int nodesExpanded = 0;

        while (!fringe.empty() && !end) {
            Node current = fringe.pop();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("~~~~~\nDFS found a solution at depth: " + current.depth);
                System.out.println("Number of nodes expanded: " + nodesExpanded);
                b.printState();
                end = true;
            } else {
                for (Node node : current.getSuccessors(true)) {
                    fringe.push(node);
                }
            }
        }
        return nodesExpanded;
    }
}
