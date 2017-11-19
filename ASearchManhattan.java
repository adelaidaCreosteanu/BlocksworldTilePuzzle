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
            Board b = current.boardState;

            if (b.isGoalState()) {
//                System.out.println("~~~~~\nA* using manhattan distance heuristic found a solution at depth: " + current.depth);
//                System.out.println("Number of nodes expanded: " + nodesExpanded);
//                b.printState();
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
