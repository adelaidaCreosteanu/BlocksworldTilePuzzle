// I considered that the agent always start at the bottom right, even though the start states will differ
// to make the problem harder/easier
public class Solver {
    public static void main(String[] args) {
        int[][] boardState = new int[][]{{0, 0, 0}, {0, 0, 'A'}, {0, 'B', 0}};
        new BFSearch(boardState);

        boardState = new int[][]{{0, 0, 0}, {0, 0, 'A'}, {0, 'B', 0}};
        new DFSearch(boardState);
    }
}
