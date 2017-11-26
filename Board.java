// This class is a representation of a physical configuration and should be encapsulated by appropriate nodes.
public class Board {
    private int[][] state;
    private int size;
    private int agentX;
    private int agentY;

    public Board(int[][] state, int agentX, int agentY) {
        this.state = state;
        size = state.length;
        this.agentX = agentX;
        this.agentY = agentY;
    }

    public int getAgentX() {
        return agentX;
    }

    public int getAgentY() {
        return agentY;
    }

    public int[][] getState() {
        return state;
    }

    public Board cloneBoard() {
        int[][] copy = new int[size][size];

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                copy[i][j] = state[i][j];
            }
        }

        return new Board(copy, agentX, agentY);
    }

    /* New position is only accepted if it's adjacent to current position and
     * within borders of the puzzle board.
     */
    public boolean isLegal(Position p) {
        if (p.x < 0 || p.y < 0 || p.x >= size || p.y >= size) {     // position out of borders
            return false;
        }
        if (Math.abs(agentX - p.x) + Math.abs(agentY - p.y) != 1) { // new position is not adjacent to agent
            return false;
        }
        return true;
    }

    /*  If move is legal, swap values of current agent position and new position where agent
     *  will move to. Then update agent position.
     */
    public void moveAgent(Position p) {
        if (isLegal(p)) {
            // Swap values in the matrix
            int aux = state[p.x][p.y];
            state[p.x][p.y] = state[agentX][agentY];
            state[agentX][agentY] = aux;

            // Update agent position
            agentX = p.x;
            agentY = p.y;
        }
    }

    /*
     *  I considered that the goal state is the ordered letter blocks stacked on top of each other
     *  at the bottom of the board, in the middle column (odd size) or to the left of the middle
     *  (even size). First row is expected to be empty.
     */
    public boolean isGoalState(){
        int col = (size - 1) / 2;

        for (int i = 1; i < size; i++) {    // Start from second row
            int expected = 'A' + i - 1;
            if (state[i][col] != expected) {
                return false;               // Incorrect block found
            }
        }

        return true;
    }

    /*
     *  This class is mainly for testing purposes and shouldn't be used when running the search algorithms.
     *  To represent the agent, it prints "!".
     */
    public void printState() {
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                if (i == agentX && j == agentY) {
                    System.out.print("@ ");
                }else if (state[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print((char) state[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
