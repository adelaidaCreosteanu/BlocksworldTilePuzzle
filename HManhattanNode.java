import java.util.ArrayList;

public class HManhattanNode extends Node implements Comparable<HManhattanNode> {
    private int cost;

    public HManhattanNode(HManhattanNode parent, int depth, Board state) {
        super(parent, depth, state);

        if (parent == null) {
            cost = manhattanDistance();
        } else {
            cost = parent.cost + manhattanDistance();
        }
    }

    private int manhattanDistance() {
        int cost = 0;
        int[][] state = boardState.getState();
        int size = state.length;
        int col = size / 2 - 1;   // expected goal column

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (state[i][j] != 0) {
                    int expectedi = state[i][j] - 'A' + 1;
                    cost += Math.abs(expectedi - i) + Math.abs(col - j);
                }
            }
        }

        return cost;
    }

    public ArrayList<HManhattanNode> getSuccessors() {
        ArrayList<HManhattanNode> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            Board b = boardState.cloneBoard();
            // Update agent position:
            b.moveAgent(newP.x, newP.y);
            list.add(new HManhattanNode(this, depth + 1, b));
        }

        return list;
    }

    @Override
    public int compareTo(HManhattanNode that) {
        return this.cost - that.cost;
    }
}
