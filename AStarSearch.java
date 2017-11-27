import java.util.PriorityQueue;

public class AStarSearch {
    private PriorityQueue<NodeHeuristic> fringe;
    private String heuristic;

    public static final String MANHATTAN = "Manhattan distance";
    public static final String HAMMING = "Hamming distance";
    public static final String ROW_COLUMN = "Out of row&column";


    public AStarSearch(int[][] state, String heuristic) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        this.heuristic = heuristic;
        NodeHeuristic root;

        if (heuristic.equals(MANHATTAN)) {
            root = new NodeManhattan(null, 0, initial);
        } else if (heuristic.equals(HAMMING)) {
            root = new NodeHamming(null, 0, initial);
        } else {
            root = new NodeRowColumn(null, 0, initial);
        }

        fringe.add(root);
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            NodeHeuristic current = fringe.poll();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                System.out.println("~~~~\n" + heuristic + " heuristic expanded: " + nodesExpanded);
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
