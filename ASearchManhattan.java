import java.util.PriorityQueue;

public class ASearchManhattan {
    private PriorityQueue<HManhattanNode> fringe;

    public ASearchManhattan(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new HManhattanNode(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            HManhattanNode current = fringe.poll();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                // Print path to goal
                System.out.println("~~~~\nA* search with manhattan heuristic expanded: " + nodesExpanded + " nodes");
                current.printPath();
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
