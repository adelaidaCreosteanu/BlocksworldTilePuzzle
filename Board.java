public class Board {
    private int size;
    private int[][] state;
    private int agentX;
    private int agentY;

    public Board (int size) {
        this.size = size;
        state = new int[size][size]; // initialises all values to 0

        // Put in letter blocks on the bottom row
        for (int j = 0; j < size-1; j ++) {
            state[size-1][j] = 65+j;  // 65 == 'A'
        }

        // Put in the agent in the bottom-right corner
        agentX = size-1;
        agentY = size-1;
    }

    public boolean agentCanMoveTo (int newX, int newY) {
        if (newX == agentX && newY == agentY)
            return false;
        if (newX < 0 || newY < 0 || newX >= size || newY >= size)
            return false;
        return true;
    }

    /*
     *  If new position contains a letter block, move it to the current position of the agent.
     *  Move agent to new position regardless of the if statement (update agentX and agentY)
     */
    public boolean moveAgent(int newX, int newY){
        if (agentCanMoveTo(newX, newY)) {
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
     *  at the bottom of the board, no matter the column.
     *  So first row should be empty.
     */
    public boolean isGoalState(){
        int col = -1;

        // Find the column of the tower
        for (int j = 0; j < size; j ++) {
            if (state[1][j] != 0) {
                col = j;
                break;
            }
        }
        if (col == -1) return false;    // I didn't find a block on the second row

        for (int i = 1; i < size; i++) {
            if (state[i][col] != 'A' + i) return false;   // Incorrect block found
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
                    System.out.print((char)state[i][j]);
                }
            }
            System.out.println();
        }
    }
}
