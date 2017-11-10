import java.util.PriorityQueue;

// This class implements A* tree search
public class ASearch {
    private PriorityQueue<HeuristicNode> fringe;
    private Board initial;
    private int heuristic = 0;

    public ASearch(int[][] state) {
        initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new PriorityQueue<>();
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int go() {
        fringe.add(new HeuristicNode(null, 0, initial, 0, heuristic));
        int nodesExpanded = 0;

        while (true) {
            HeuristicNode current = fringe.poll();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                String heuristicText = " using No. misplaced tiles ";
                if (heuristic == 1) heuristicText = " using manhattan distance ";

                System.out.println("~~~~~\nA*" + heuristicText + "found a solution at depth: " + current.depth);
                System.out.println("Number of nodes expanded: " + nodesExpanded);
                b.printState();
                return nodesExpanded;
            } else {
                for (HeuristicNode node : current.getSuccessors()) {
                    fringe.add(node);
                }
            }
        }
    }
}
