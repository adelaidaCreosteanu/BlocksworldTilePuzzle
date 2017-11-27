import java.util.PriorityQueue;

public class AShamming {
    private PriorityQueue<NodeHamming> fringe;

    public AShamming(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new NodeHamming(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            NodeHamming current = fringe.poll();
            nodesExpanded++;

            if (current.boardState.isGoalState()) {
                // Print path to goal
                System.out.println("~~~~\nA* search expanded: " + nodesExpanded + " nodes");
                current.printPath();
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}