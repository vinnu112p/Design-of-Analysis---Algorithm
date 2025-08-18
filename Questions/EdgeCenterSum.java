public class EdgeCenterSum {

public static void main(String[] args) {

int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};

int m = matrix.length;
int n = matrix.length/2;

int top  = matrix[0][n];
int bottom = matrix[m-1][n];
int left = matrix[0][n];
int right = matrix[m-1][n];

int sum = top + bottom + left + right;



 System.out.println("Sum of edge elements: " + sum);




}


}