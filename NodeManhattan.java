import java.util.ArrayList;

public class NodeManhattan extends Node implements Comparable<NodeManhattan> {
    private int cost;

    public NodeManhattan(NodeManhattan parent, int depth, Board state) {
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
        int col = (size - 1) / 2;   // expected goal column

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

    public ArrayList<NodeManhattan> getSuccessors() {
        ArrayList<NodeManhattan> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP);
                list.add(new NodeManhattan(this, depth + 1, b));
            }
        }

        return list;
    }

    @Override
    public int compareTo(NodeManhattan that) {
        return this.cost - that.cost;
    }
}
