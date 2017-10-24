public class Board {
    private int size;
    private int[][] state;
    private int agentX;
    private int agentY;

    public Board (int size) {
        this.size = size;
        state = new int[size][size]; // initialises all values to 0

        // Put in letter blocks
        for (int j = 0; j < size-1; j ++) {
            state[size-1][j] = 65+1;  // 65 == 'A'
        }

        // Put in the agent in the bottom-right corner
        agentX = size-1;
        agentY = size-1;
    }

    public boolean agentCanMoveTo (int newX, int newY) {
        return true;
    }

    public void moveAgent(int newX, int newY){
        if (agentCanMoveTo(newX, newY)) {
            // move agent
        }
    }

    public boolean isGoalState(){
        return false;
    }

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
