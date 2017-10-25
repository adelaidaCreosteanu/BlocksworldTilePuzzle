import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BFSearch {
    LinkedList<BFNode> fringe;

    public BFSearch(int[][] state) {
        fringe = new LinkedList<>();

        Board initial = new Board(state, state.length - 1, state.length - 1);
        fringe.add(new BFNode(null, 0, initial));
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
