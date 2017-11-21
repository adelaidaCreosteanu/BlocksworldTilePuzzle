// I considered that the agent always start at the bottom right, even though the start states will differ
// to make the problem harder/easier
public class Solver {
    public static void main(String[] args) {
//        int bf = new BFSearch(createBoardState(3)).go();
//        System.out.println("BFSearch: " + bf);

//        int df = 0;
//        int id = 0;
//        int n = 100000;
//        for (int i = 0; i < n; i++) {
//            df += new DFSearch(createBoardState(3)).go();
//            id += new IDSearch(createBoardState(3)).go();
//        }
//        System.out.println("DFSearch: " + df/n);
//        System.out.println("IDSearch: " + id/n);
//
//        int mis = new ASearchMisplaced(createBoardState(3)).go();
//        int man = new ASearchManhattan(createBoardState(3)).go();
//
//        // printing 3x3 results
//        System.out.println("ASearchMisplaced: " + mis);
//        System.out.println("ASearchManhattan: " + man);
//        System.out.println();

        //Testing A* over larger inputs
//        int mis  = new ASearchMisplaced(createBoardState(3)).go();
//        int man = new ASearchManhattan(createBoardState(3)).go();
//        System.out.println("Misplaced size 3: " + mis);
//        System.out.println("Manhattan size 3: " + man);
//        mis  = new ASearchMisplaced(createBoardState(4)).go();
//        man = new ASearchManhattan(createBoardState(4)).go();
//        System.out.println("Misplaced size 4: " + mis);
//        System.out.println("Manhattan size 4: " + man);
//        mis  = new ASearchMisplaced(createBoardState(5)).go();
//        man = new ASearchManhattan(createBoardState(5)).go();
//        System.out.println("Misplaced size 5: " + mis);
//        System.out.println("Manhattan size 5: " + man);



    }

    public static Board createBoardFromGoal(int size, int moves) {
        Board board = new Board(createGoalState(size), size - 1, size - 1);

        //iterate on moves and make the agent move to a random place and then return the board
        //use this method several times to test search methods.
    }

    public static int[][] createGoalState(int size) {
        int[][] b = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == size / 2) {
                    b[i][j] = 'A' + i - 1;
                } else {
                    b[i][j] = 0;
                }
            }
        }

        return b;
    }
}
