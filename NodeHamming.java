import java.util.ArrayList;

public class NodeHamming extends NodeHeuristic {
    public NodeHamming(NodeHamming parent, int depth, Board state) {
        super(parent, depth, state);
    }

    // Counts how many blocks are not in their goal place
    // Adds 1 if it's worse than it's parent
    protected int heuristic() {
        int cost = 0;
        int[][] state = boardState.getState();
        int size = state.length;
        int col = (size - 1) / 2;     // expected goal column

        for (int i = 1; i < state.length; i++) {
            int expected = 'A' + i - 1;
            if (state[i][col] != expected) {
                cost++;
            }
        }

        return cost;
    }

    public ArrayList<NodeHeuristic> getSuccessors() {
        ArrayList<NodeHeuristic> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP);
                list.add(new NodeHamming(this, depth + 1, b));
            }
        }

        return list;
    }
}
