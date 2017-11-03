import java.util.LinkedList;

// This class implements Breadth-first tree search
public class BFSearch {
    private LinkedList<Node> fringe;

    public BFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        go(new Node(null, 0, initial));
    }

    private void go(Node root) {
        fringe = new LinkedList<>();
        fringe.add(root);
        boolean end = false;
        int nodesExpanded = 0;

        while (!fringe.isEmpty() && !end) {
            Node current = fringe.remove();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("~~~\nBFS found a solution at depth: " + current.depth);
                System.out.println("Number of nodes expanded: " + nodesExpanded);
                b.printState();
                end = true;
            } else {
                for (Node node : current.getSuccessors(true)) {    // Get successors in a random order
                    fringe.add(node);
                }
            }
        }
    }
}
