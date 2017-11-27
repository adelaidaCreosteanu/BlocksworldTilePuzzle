import java.util.ArrayList;

public class NodeRowColumn extends Node implements Comparable<NodeRowColumn> {
    private int cost;

    public NodeRowColumn(NodeRowColumn parent, int depth, Board state) {
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

    public ArrayList<NodeRowColumn> getSuccessors() {
        ArrayList<NodeRowColumn> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP);
                list.add(new NodeRowColumn(this, depth + 1, b));
            }
        }

        return list;
    }

    @Override
    public int compareTo(NodeRowColumn that) {
        return this.cost - that.cost;
    }
}
