public class Solver {
    public static void main(String[] args) {
        int[][] boardState = new int[][]{{0, 0, 0}, {0, 0, 0}, {65, 66, 0}};
        Board board = new Board(boardState, 2, 2, 2, 0);

        board.printState();
    }
}
