import java.util.PriorityQueue;

// This class implements A* tree search
public class ASearchMisplaced {
    private PriorityQueue<HMisplacedNode> fringe;

    public ASearchMisplaced(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
        fringe.add(new HMisplacedNode(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            HMisplacedNode current = fringe.poll();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
//                System.out.println("~~~~~\nA* using misplaced tiles heuristic found a solution at depth: " + current.depth);
//                System.out.println("Number of nodes expanded: " + nodesExpanded);
//                b.printState();
                return nodesExpanded;
            } else {
                fringe.addAll(current.getSuccessors());
            }
        }
    }
}
