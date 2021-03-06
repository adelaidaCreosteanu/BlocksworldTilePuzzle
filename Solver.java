public class Solver {
    public static void main(String[] args) {
        int[][][] boards = {createStartA(3), createStartB(3), createStartC(3), createStartD(3), createStartE(3), createStartF(3)};
        int[][][] bigBoards = {createStartA(4), createStartB(4), createStartC(4), createStartD(4), createStartE(4), createStartF(4)};

        System.out.println("3x3\n");
        int n = 10000;
        for (int i = 1; i <= boards.length; i++) {
            int df = 0, id = 0;
            System.out.println(i);
            new BFSearch(copyMatrix(boards[i])).go();
            for (int j = 0; j < n; j++) {
                df += new DFSearch(copyMatrix(boards[i])).go();
                id += new IDSearch(copyMatrix(boards[i])).go();
            }
            System.out.println("~~~~\nDFSearch expanded: " + df / n);
            System.out.println("~~~~\nIDSearch expanded: " + id / n);

            new AStarSearch(copyMatrix(boards[i]), AStarSearch.MANHATTAN).go();
            new AStarSearch(copyMatrix(boards[i]), AStarSearch.HAMMING).go();
            new AStarSearch(copyMatrix(boards[i]), AStarSearch.ROW_COLUMN).go();
        }

        System.out.println();
        System.out.println("4x4\n");
        n = 50;
        for (int i = 1; i <= bigBoards.length; i++) {
            int df = 0, id = 0;
            System.out.println(i);

            new BFSearch(copyMatrix(bigBoards[i])).go();
            for (int j = 0; j < n; j++) {
                df += new DFSearch(copyMatrix(bigBoards[i])).go();
                id += new IDSearch(copyMatrix(bigBoards[i])).go();
            }
            System.out.println("~~~~\nDFSearch expanded: " + df / n);
            System.out.println("~~~~\nIDSearch expanded: " + id / n);

            new AStarSearch(copyMatrix(bigBoards[i]), AStarSearch.MANHATTAN).go();
            new AStarSearch(copyMatrix(bigBoards[i]), AStarSearch.HAMMING).go();
            new AStarSearch(copyMatrix(bigBoards[i]), AStarSearch.ROW_COLUMN).go();
        }
    }

    static int[][] copyMatrix(int[][] state) {
        int size = state.length;
        int[][] copy = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = state[i][j];
            }
        }
        return copy;
    }

    public static int[][] createStartA(int size) {
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

    public static int[][] createStartB(int size) {
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

    public static int[][] createStartC(int size) {
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

    public static int[][] createStartD(int size) {
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

    public static int[][] createStartE(int size) {
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

    public static int[][] createStartF(int size) {
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
}
