import java.util.LinkedList;

// This class implements Breadth-first tree search
public class BFSearch {
    private LinkedList<Node> fringe;

    public BFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe = new LinkedList<>();
        fringe.add(new Node(null, 0, initial));
    }

    public int go() {
        int nodesExpanded = 0;

        while (true) {
            Node current = fringe.remove();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("~~~~~\nBFS found a solution at depth: " + current.depth);
                System.out.println("Number of nodes expanded: " + nodesExpanded);
                b.printState();
                return nodesExpanded;
            } else {
                for (Node node : current.getSuccessors(false)) {
                    fringe.add(node);
                }
            }
        }
    }
}
