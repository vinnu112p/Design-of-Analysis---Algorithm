public class DiagonalSum{

public static void main(String[] args) {

int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};

for(int i = 0; i < matrix.length; i++){
    for(int j = 0; j < matrix.length; j++){

        if(i == j || i + j == matrix.length - 1){
            System.out.print(matrix[i][j] + " ");
        } else {
            System.out.print("  ");// print a space for alignment

        }

    }
}




}


}