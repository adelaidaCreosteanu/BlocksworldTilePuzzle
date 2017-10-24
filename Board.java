public class Board {
    private int size;
    private int[][] state;
    private int agentx;
    private int agenty;

    public Board (int size) {
        this.size = size;
        state = new int[size][size];

        // Put in zeros
        for (int i = 0; i < size-1; i ++) {
            for (int j = 0; j < size; j ++) {
                state[i][j] = 0;
            }
        }

        // Put in letter blocks
        for (int j = 0; j < size-1; j ++) {
            state[size-1][j] = 65+1;
        }

        // Put in the agent in the bottom-right corner
        agentx = size-1;
        agenty = size-1;
    }
}
