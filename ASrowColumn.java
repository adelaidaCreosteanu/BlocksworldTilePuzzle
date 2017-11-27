import java.util.PriorityQueue;

public class ASrowColumn {
    private PriorityQueue<NodeRowColumn> fringe;

    public ASrowColumn(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new NodeRowColumn(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            NodeRowColumn current = fringe.poll();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
