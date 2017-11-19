// I considered that the agent always start at the bottom right, even though the start states will differ
// to make the problem harder/easier
public class Solver {
    public static void main(String[] args) {
        int[][] boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        new BFSearch(boardState).go();

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        new DFSearch(boardState).go();

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        new IDSearch(boardState).go();

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        new ASearchMisplaced(boardState).go();   // no misplaced tiles

        boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {'A', 'B', 0}};
        new ASearchManhattan(boardState).go();
    }
}
