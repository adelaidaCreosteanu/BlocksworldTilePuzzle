import java.util.ArrayDeque;

public class BFSearch {
    private ArrayDeque<Node> fringe;    // used as FIFO

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

            // Print statements to see order of node expansion
//            System.out.println("Depth: " + current.depth);
//            current.boardState.printState();
//            System.out.println();

            if (current.boardState.isGoalState()) {
                System.out.println("~~~~\nBFSearch expanded: " + nodesExpanded + " nodes");
                return nodesExpanded;
            } else {
                for (Node n : current.getSuccessors(false)) {
                    fringe.offer(n);
                }
            }
        }
    }
}
