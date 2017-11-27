import java.util.ArrayList;

public class NodeRow_column extends Node implements Comparable<NodeRow_column> {
    private int cost;

    public NodeRow_column(NodeRow_column parent, int depth, Board state) {
        super(parent, depth, state);

        if (parent == null) {
            cost = outOfRowColumn();
        } else {
            cost = parent.cost + outOfRowColumn();
        }
    }

    private int outOfRowColumn() {
        int cost = 0;
        int[][] state = boardState.getState();
        int size = state.length;
        int col = (size - 1) / 2;     // expected goal column

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (state[i][j] != 0) {
                    int expectedi = state[i][j] - 'A' + 1;
                    if (i != expectedi) cost++;
                    if (j != col) cost++;
                }
            }
        }

        return cost;
    }

    public ArrayList<NodeRow_column> getSuccessors() {
        ArrayList<NodeRow_column> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP);
                list.add(new NodeRow_column(this, depth + 1, b));
            }
        }

        return list;
    }

    @Override
    public int compareTo(NodeRow_column that) {
        return this.cost - that.cost;
    }
}
