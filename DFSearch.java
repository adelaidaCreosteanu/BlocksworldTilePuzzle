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

            // Print statements to see order of node expansion
            System.out.println("Depth: " + current.depth);
            current.boardState.printState();
            System.out.println();

            if (current.boardState.isGoalState()) {
                System.out.println("~~~~\nDFSearch expanded " + nodesExpanded + " nodes");
                return nodesExpanded;
            } else {
                for (Node n : current.getSuccessors(true)) {
                    fringe.push(n);
                }
            }
        }
    }
}
