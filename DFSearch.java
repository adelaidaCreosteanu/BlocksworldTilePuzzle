import java.util.Stack;

public class DFSearch {
    Stack<Node> fringe;

    public DFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        go(new Node(null, 0, initial));
    }

    private void go(Node root) {
        fringe = new Stack<>();
        fringe.push(root);
        boolean end = false;
        int nodesExpanded = 0;

        while (!fringe.empty() && !end) {
            Node current = fringe.pop();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("~~~~~\nDFS found a solution at depth: " + current.depth + "\nNumber of nodes expanded: " + nodesExpanded);
                b.printState();
                end = true;
            } else {
                for (Node node : current.getSuccessors()) {
                    fringe.push(node);
                }
            }
        }

    }
}
