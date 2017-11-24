import java.util.ArrayList;

public class HMisplacedNode extends Node implements Comparable<HMisplacedNode> {
    private int cost;

    public HMisplacedNode(HMisplacedNode parent, int depth, Board state) {
        super(parent, depth, state);

        if (parent == null) {
            cost = misplacedTiles();
        } else {
            cost = parent.cost + misplacedTiles();
        }
    }

    // Counts how many blocks are not in their goal place
    private int misplacedTiles() {
        int misplaced = 0;
        int[][] state = boardState.getState();
        int col = state.length / 2;     // expected goal column

        for (int i = 1; i < state.length; i++) {
            int expected = 'A' + i - 1;
            if (state[i][col] != expected) {
                misplaced++;
            }
        }

        return misplaced;
    }

    public ArrayList<HMisplacedNode> getSuccessors() {
        ArrayList<HMisplacedNode> list = new ArrayList<>(4);
        Position curr = new Position(boardState.getAgentX(), boardState.getAgentY());


        for (Position newP : curr.getAdjacent(false)) {
            if (boardState.isLegal(newP.x, newP.y)) {
                Board b = boardState.cloneBoard();
                // Update agent position:
                b.moveAgent(newP.x, newP.y);
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
