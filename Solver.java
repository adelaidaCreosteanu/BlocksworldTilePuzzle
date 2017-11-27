public class Solver {
    public static void main(String[] args) {
        // Prove methods work

//        new BFSearch(createStart6(4)).go();
//        new DFSearch(createStart6(4)).go();
//        new IDSearch(createStart6(4)).go();

        new AStarSearch(createStart3(4), AStarSearch.MANHATTAN).go();
        new AStarSearch(createStart3(4), AStarSearch.HAMMING).go();
        new AStarSearch(createStart3(4), AStarSearch.ROW_COLUMN).go();
    }

    //    0 0 0 0
//    0 0 0 0
//    0 0 0 0
//    A B C 0
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

    //    0 0 0 0
//    0 0 0 0
//    A B C 0
//    0 0 0 0
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

    //    A 0 0 0
//    0 B 0 0
//    0 0 C 0
//    0 0 0 0
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

    //    0 0 0 0
//    A 0 0 0
//    0 B 0 0
//    0 0 C 0
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

    //    0 0 A 0
//    0 0 B 0
//    0 0 C 0
//    0 0 0 0
    public static int[][] createStart2(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int i = 0; i < size - 1; i++) {
            state[i][(size - 1) / 2 + 1] = 'A' + i;
        }

        return state;
    }

    //    0 A 0 0
//    0 B 0 0
//    0 C 0 0
//    0 0 0 0
    public static int[][] createStart1(int size) {
        int[][] state = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = 0;
            }
        }
        for (int i = 0; i < size - 1; i++) {
            state[i][(size - 1) / 2] = 'A' + i;
        }

        return state;
    }
}
