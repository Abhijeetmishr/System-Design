package DSA.Matrix;

/**
 * https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateImage {
    public int[][] rotateImage(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        //transpose of a matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }

        //swap columns 0 -> n-1, 1 -> n-2
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = 0;
                temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        return matrix;
    }
}
