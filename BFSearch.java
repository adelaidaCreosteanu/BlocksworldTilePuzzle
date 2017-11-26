import java.util.ArrayDeque;

// This class implements Breadth-first tree search
public class BFSearch {
    private ArrayDeque<Node> fringe; // used as FIFO

    public BFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new ArrayDeque<>();
        fringe.offer(new Node(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            Node current = fringe.poll();
            nodesExpanded++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                // Print path to goal
                System.out.println("~~~~\nBFSearch expanded: " + nodesExpanded + " nodes");
                current.printPath();
                return nodesExpanded;
            } else {
                for (Node n : current.getSuccessors(false)) {
                    fringe.offer(n);
                }
            }
        }
    }
}
