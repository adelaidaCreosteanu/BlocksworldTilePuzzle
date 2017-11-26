public class Solver {
    public static void main(String[] args) {
        // Prove methods work

        new BFSearch(createStart1(4)).go();
        new DFSearch(createStart1(4)).go();
        new IDSearch(createStart1(4)).go();
    }

    // All letters on the last row
    public static int[][] createStart6(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int j = 0; j < size - 1; j++) {
            state[size - 1][j] = 'A' + j;
        }

        return state;
    }

    // All letters on the penultimate row
    public static int[][] createStart5(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int j = 0; j < size - 1; j++) {
            state[size - 2][j] = 'A' + j;
        }

        return state;
    }

    // All letters on the main diagonal
    public static int[][] createStart4(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    state[i][j] = i + 'A';
                } else {
                    state[i][j] = 0;
                }
            }
        }

        return state;
    }

    // All letters on the diagonal below the main top left - bottom right diagonal
    public static int[][] createStart3(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j + 1) {
                    state[i][j] = i + 'A' - 1;
                } else {
                    state[i][j] = 0;
                }
            }
        }

        return state;
    }

    // All letters on the column to the right of the goal column, shifted up
    public static int[][] createStart2(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int i = 0; i < size - 1; i++) {
            state[i][size / 2] = 'A' + i;
        }

        return state;
    }

    // All letters on the goal column shifted up one block
    public static int[][] createStart1(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int i = 0; i < size - 1; i++) {
            state[i][size / 2 - 1] = 'A' + i;
        }

        return state;
    }
}
