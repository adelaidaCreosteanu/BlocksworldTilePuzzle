// Used by A* search
public class HeuristicNode extends Node implements Comparable<HeuristicNode> {
    private int cost;

    public HeuristicNode(Node parent, int depth, Board state, int parentCost, int heuristic) {
        super(parent, depth, state);

        if (heuristic == 0) {
            cost = parentCost + noMisplacedBlocks();
        } else {
            cost = parentCost + manhattanDistance();
        }
    }

    // Counts how many blocks are not in their goal place
    private int noMisplacedBlocks() {
        int n = 0;
        int[][] state = boardState.getState();
        int col = (state.length - 1)/2;

        for (int i = 1; i < state.length; i++) {
            int expected = 'A' + i - 1;
            if (state[i][col] != expected) {
                n ++;
            }
        }

        return n;
    }

    // Counts how far away each block is from their goal
    private int manhattanDistance() {
        int n = 0;
        int[][] state = boardState.getState();
        int size = state.length;
        int col = (size - 1)/2;

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                if (state[i][j] != 0) {
                    int expectedi = state[i][j] - 'A' + 1;
                    n += Math.abs(i - expectedi) + Math.abs(j - col);
                }
            }
        }

        return n;
    }

    public int compareTo(HeuristicNode that) {
        return this.cost - that.cost;
    }
}
