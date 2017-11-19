// I considered that the agent always start at the bottom right, even though the start states will differ
// to make the problem harder/easier
public class Solver {
    public static void main(String[] args) {
        int[][] boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        //int bf = new BFSearch(createBoardState(3)).go();

        int df = 0;
        int id = 0;
        for (int i = 0; i < 10; i++) {
            boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
            df += new DFSearch(createBoardState(4)).go();

            boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
            id += new IDSearch(createBoardState(4)).go();
        }
        df /= 10;
        id /= 10;

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        int mis = new ASearchMisplaced(createBoardState(4)).go();

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        int man = new ASearchManhattan(createBoardState(4)).go();

        // printing 3x3 results
//        System.out.println("BFSearch: " + bf);
        System.out.println("DFSearch: " + df);
        System.out.println("IDSearch: " + id);
        System.out.println("ASearchMisplaced: " + mis);
        System.out.println("ASearchManhattan: " + man);
        System.out.println();

        //Testing A* over larger inputs
//        for (int i = 4; i < 8; i ++) {
//            mis = new ASearchMisplaced(createBoardState(i)).go();
//            man = new ASearchManhattan(createBoardState(i)).go();
//            System.out.println("For board size: " + i);
//            System.out.println("ASearchMisplaced: " + mis);
//            System.out.println("ASearchManhattan: " + man);
//        }

    }

    public static int[][] createBoardState(int size) {
        int[][] b = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                b[i][j] = 0;
            }
        }

        for (int j = 0; j < size - 1; j++) {
            b[size - 1][j] = 'A' + j;
        }

        return b;
    }
}
