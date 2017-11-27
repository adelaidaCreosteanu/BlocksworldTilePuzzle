import java.util.PriorityQueue;

public class ASrow_column {
    private PriorityQueue<NodeRow_column> fringe;

    public ASrow_column(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new NodeRow_column(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            NodeRow_column current = fringe.poll();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
