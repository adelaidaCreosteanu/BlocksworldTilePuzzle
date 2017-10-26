import java.util.ArrayList;
import java.util.Collections;

public class BFSearch {
    private ArrayList<Node> fringe;
    private int nodesExpanded;

    public BFSearch(Board initial) {
        fringe = new ArrayList<>();

        fringe.add(new BFNode(null, 0, initial));
        expand();
    }

    private void expand() {
        nodesExpanded++;
        Node expandedNode = fringe.remove(0);

        if (expandedNode.depth < 4) {
            if (expandedNode.boardState.isGoalState()) {
                System.out.println("=====   BREADTH FIRST STATS   =====");
                System.out.println("Nodes expanded: " + nodesExpanded);
                System.out.println("Depth reached: " + expandedNode.depth);
                System.out.println("Solution found:");
                expandedNode.boardState.printState();
            } else {
                for (Node n : expandedNode.getSuccessors()) {
                    fringe.add(n);
                    expandedNode.boardState.printState();
                    System.out.println("  ||  ");
                    System.out.println("  \\/  ");
                    n.boardState.printState();
                    System.out.println("--------");
                }

                expand();
            }
        }
    }

    private class BFNode extends Node {
        public BFNode(BFNode parent, int depth, Board boardState) {
            super(parent, depth, boardState);
        }

        public ArrayList<Node> getSuccessors() {
            ArrayList<Node> list = new ArrayList<>(4);
            int x = boardState.getAgentX();
            int y = boardState.getAgentY();

            for (Position newP : getRandomisedPositions(x, y)) {
                if (boardState.isLegal(newP.x, newP.y)) {
                    Board b = new Board(boardState.getState(), x, y);
                    b.moveAgent(newP.x, newP.y);
                    list.add(new BFNode(this, depth + 1, b));
                }
            }

            return list;
        }

        /*
         * Puts the four neighbours of the coordinates received as arguments in a list and returns
         * the shuffled list. The returned list can contain illegal positions (outside the board)
         * but this is dealt with in the Board class
         */
        private ArrayList<Position> getRandomisedPositions(int x, int y) {
            ArrayList<Position> p = new ArrayList<>(4);

            p.add(new Position(x - 1, y));
            p.add(new Position(x, y + 1));
            p.add(new Position(x + 1, y));
            p.add(new Position(x, y - 1));

            Collections.shuffle(p);

            return p;
        }
    }
}
