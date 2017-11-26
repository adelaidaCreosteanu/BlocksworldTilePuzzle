import java.util.ArrayDeque;

public class DFSearch {
    private ArrayDeque<Node> fringe;    // used as LIFO

    public DFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new ArrayDeque<>();
        fringe.push(new Node(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            Node current = fringe.pop();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                // Print path to goal
                System.out.println("~~~~\nDFSearch expanded " + nodesExpanded + " nodes");
//                current.printPath();

                return nodesExpanded;
            } else {
                for (Node n : current.getSuccessors(true)) {
                    fringe.push(n);
                }
            }
        }
    }
}