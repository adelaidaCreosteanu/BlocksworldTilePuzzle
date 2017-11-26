import java.util.ArrayList;

public class HMisplacedNode extends Node implements Comparable<HMisplacedNode> {
    private int cost;
    private HMisplacedNode parent;

    public HMisplacedNode(HMisplacedNode parent, int depth, Board state) {
        super(parent, depth, state);
        this.parent = parent;

        if (parent == null) {
            cost = misplacedTiles();
        } else {
            cost = parent.cost + misplacedTiles();
        }
    }

    // Counts how many blocks are not in their goal place
    private int misplacedTiles() {
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

        if (parent != null && parent.misplacedTiles() < cost) {
            cost += 1;
        }

        return cost;
    }

    public ArrayList<HMisplacedNode> getSuccessors() {
        ArrayList<HMisplacedNode> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());

        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP);
                list.add(new HMisplacedNode(this, depth + 1, b));
            }
        }

        return list;
    }

    @Override
    public int compareTo(HMisplacedNode that) {
        return this.cost - that.cost;
    }
}
