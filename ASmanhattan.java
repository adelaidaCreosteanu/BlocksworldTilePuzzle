import java.util.PriorityQueue;

public class ASmanhattan {
    private PriorityQueue<NodeManhattan> fringe;

    public ASmanhattan(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new NodeManhattan(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            NodeManhattan current = fringe.poll();
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
