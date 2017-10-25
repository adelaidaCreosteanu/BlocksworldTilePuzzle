import java.util.ArrayList;
import java.util.LinkedList;

public class BFSearch {
    LinkedList<BFNode> queue;

    private class BFNode extends Node {
        public BFNode(BFNode parent, int depth, Board boardState) {
            super(parent, depth, boardState);
        }

        public ArrayList<Node> getSuccessors() {
            ArrayList<Node> list = new ArrayList<>(4);
            int x = boardState.getAgentX();
            int y = boardState.getAgentY();

            for (Position newP : randomiseOrder(x, y)) {
                if (boardState.isLegal(newP.x, newP.y)) {
                    Board b = new Board(boardState.getState(), x, y, newP.x, newP.y);
                    list.add(new BFNode(this, depth + 1, b));
                }
            }

            return list;
        }

        /*
         * I'm using a quasi-random way to create the order of node expansion.
         * It's random enough for breadth-first not to get stuck in a loop.
         */
        private ArrayList<Position> randomiseOrder(int x, int y) {
            ArrayList<Position> p = new ArrayList<>(4);
            double r = Math.random();

            if (r < 0.5) {
                r = Math.random();
                if (r < 0.5) {
                    p.add(new Position(x + 1, y));
                    p.add(new Position(x - 1, y));
                } else {
                    p.add(new Position(x - 1, y));
                    p.add(new Position(x + 1, y));
                }
                r = Math.random();
                if (r < 0.5) {
                    p.add(new Position(x, y + 1));
                    p.add(new Position(x, y - 1));
                } else {
                    p.add(new Position(x, y - 1));
                    p.add(new Position(x, y + 1));
                }
            } else {
                r = Math.random();
                if (r < 0.5) {
                    p.add(new Position(x, y + 1));
                    p.add(new Position(x, y - 1));
                } else {
                    p.add(new Position(x, y - 1));
                    p.add(new Position(x, y + 1));
                }
                r = Math.random();
                if (r < 0.5) {
                    p.add(new Position(x + 1, y));
                    p.add(new Position(x - 1, y));
                } else {
                    p.add(new Position(x - 1, y));
                    p.add(new Position(x + 1, y));
                }
            }

            return p;
        }
    }
}
