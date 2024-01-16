package DSA.Matrix;

public class MagicSquare {
    public static boolean matrix(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;

        if(row != col) return false;
        int sum = 0;
        for(int i = 0; i < row; i++){
           sum += mat[i][i];
        }

        for(int i = 0; i < row; i++){
            int rowSum = 0;
            for(int j = 0; j < col; j++){
                rowSum += mat[i][j];
            }
            if(rowSum != sum) return false;
        }

        for(int i = 0; i < row; i++){
            int colSum = 0;
            for(int j = 0; j < col; j++){
                colSum += mat[j][i];
            }
            if(colSum != sum) return false;
        }

        return true;
    }

    public static void main(String[] args){
        int[][] mat = {{2, 7, 6},
                       {9, 5, 1},
                       {4, 3, 8}};

        System.out.println(matrix(mat));
    }
}
