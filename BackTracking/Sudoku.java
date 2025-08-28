
public class Sudoku {


    public static boolean isSafe(int sudoku[][],int row, int col, int digit){

        // Col
        for(int i = 0; i < 9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        //Row

         for(int i = 0; i < 9; i++){
            if(sudoku[row][i] == digit){
                return false;
            }
        }

        //Grid

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i = startRow; i < startRow+3; i++){
            for(int j = startCol; j < startCol+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }


        return true; 

    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {

        //BASE

        if(row == 9 && col == 0){
            return true; 
        }
        //RECURSION
        int newRow = row;
        int newCol = col + 1;

        if (col + 1 == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        if(sudoku[row][col]!= 0){
            return sudokuSolver(sudoku, newRow, newCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku,row,col,digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, newRow, newCol))
                {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]){

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j] +" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {

        int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3}

        };

        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Sudoku Solved");
            printSudoku(sudoku);
        }else{
            System.out.println("No solution exist");
        }

    }

}
