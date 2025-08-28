
public class NQueens {

    public static boolean isSafe(char board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left dia
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }

        }

        // right dia
        for (int i = row - 1, j = col + 1; i>=0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') { 
                return false;
            }

        }

        return true;
    }

    public static void nQueens(char board[][], int row) {

        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {

            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1);
                board[row][i] = 'X';
            }

        }
    }

    public static void printBoard(char board[][]) {

        System.out.println("--------Board-------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");

        }

    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        //initialize;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }

        nQueens(board, 0);
    }
}
