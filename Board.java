// This class is a representation of a physical configuration and should be encapsulated by appropriate nodes.
public class Board {
    private int[][] state;
    private int size;
    private int agentX;
    private int agentY;

    public Board(int[][] state, int agentX, int agentY, int newX, int newY) {
        this.state = state;
        size = state.length;
        this.agentX = agentX;
        this.agentY = agentY;

        if (isLegal(newX, newY)) moveAgent(newX, newY);
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

    /*
         * New position is only accepted if it's adjacent to current position and
         * within borders of the puzzle board.
         */
    public boolean isLegal (int newX, int newY) {
        int positionDifference = Math.abs(newX - agentX) + Math.abs(newY - agentY);

        if (positionDifference != 1) {     // new position not adjacent to current
            return false;
        }

        if (newX < 0 || newY < 0 || newX > size || newY > size) {  // position ouf of borders
            return false;
        }

        return true;
    }

    /*  If new position contains a letter block, move it to the current position of the agent.
     *  Move agent to new position regardless of the if statement (update agentX and agentY)
     */
    public boolean moveAgent(int newX, int newY){
        if (isLegal(newX, newY)) {
            if (state[newX][newY] != 0) {
                state[agentX][agentY] = state[newX][newY];
            }

            agentX = newX;
            agentY = newY;
            return true;
        }

        return false;
    }

    /*
     *  I considered that the goal state is the ordered letter blocks stacked on top of each other
     *  at the bottom of the board, no matter in which column.
     *  There should be size-1 letter blocks, so the first row is expected to be empty.
     */
    public boolean isGoalState(){
        int col = -1;

        // Find the column of the tower by looking at the second row
        for (int j = 0; j < size; j ++) {
            if (state[1][j] != 0) {
                col = j;
                break;
            }
        }
        if (col == -1) return false;    // Didn't find a block on the second row

        for (int i = 1; i < size; i++) {
            int expectedLetter = 'A' + i - 1;
            if (state[i][col] != expectedLetter) return false;   // Incorrect block found
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
                    System.out.print("! ");
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
