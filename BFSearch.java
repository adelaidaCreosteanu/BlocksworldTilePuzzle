import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BFSearch {
    LinkedList<BFNode> fringe;

    public BFSearch(int[][] state) {
        Board initial = new Board(state, state.length - 1, state.length - 1);
        go(new BFNode(null, 0, initial));
    }

    private void go(BFNode root) {
        fringe = new LinkedList<>();
        fringe.add(root);
        boolean end = false;
        int nodesExpanded = 0;

        while (!fringe.isEmpty() && !end) {
            BFNode current = fringe.remove();
            nodesExpanded ++;
            Board b = current.boardState;

            if (b.isGoalState()) {
                System.out.println("Solution found at depth: " + current.depth + "\nNumber of nodes expanded: " + nodesExpanded);
                b.printState();
                end = true;
            } else {
                for (Node n : current.getSuccessors()) {
                    fringe.add((BFNode) n);
                }
            }
        }
    }

    private class BFNode extends Node {
        private BFNode(BFNode parent, int depth, Board boardState) {
            super(parent, depth, boardState);
        }

        public ArrayList<Node> getSuccessors() {
            ArrayList<Node> list = new ArrayList<>(4);
            int x = boardState.getAgentX();
            int y = boardState.getAgentY();

            for (Position newP : getRandomisedPositions(x, y)) {
                if (boardState.isLegal(newP.x, newP.y)) {
                    Board b = new Board(boardState.getState(), x, y);
                    b.moveAgent(newP.x, newP.y);               //update the state
                    list.add(new BFNode(this, depth + 1, b));
                }
            }

            return list;
        }
    }
}
