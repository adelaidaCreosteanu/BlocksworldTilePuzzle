public class Solver {
    public static void main(String[] args) {
        int[][] boardState = new int[][]{{0, 0, 0}, {0, 'A', 0}, {'B', 0, 0}};
        Board board = new Board(boardState, 1, 0);

        new BFSearch(board);
    }
}
