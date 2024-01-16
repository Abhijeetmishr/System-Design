package DSA.Matrix;
import java.util.*;

public class SpiralMatrix {
    public static int[][] spiralMatrix(int N){
        int[][] matrix = new int[N][N];
        
        int top = 0;
        int bottom = N-1;
        int left = 0;
        int right = N-1;
        int count = 1;

        while(count <= N*N){
            // Move right
            for(int i = left; i <= right; i++){
                matrix[top][i] = count;
                count++;
            }
            top++;
            // Move down
            for(int i = top; i <= bottom; i++){
                matrix[i][right] = count;
                count++;
            }
            right--;
            //move left
            for(int i = right; i >= left; i--){
                matrix[bottom][i] = count;
                count++;
            }
            bottom--;
            //move up
            for(int i = bottom; i >= top; i--){
                matrix[i][left] = count;
                count++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][] = spiralMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
