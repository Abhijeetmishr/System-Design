package DSA.Backtracking;

public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        return isValid(board, 0, 0);
    }
    
    public boolean isValid(char[][] board, int r, int c){
        if(c == board[0].length){
            r++;
            c = 0;
        }

        //base condition
        if(r == board.length){
            return true;
        }

        char digit = board[r][c];
        if(digit != '.'){
            board[r][c] = '.';//change the digit to '.' so it cannot check the curr digit
            if(!isSafe(board, r, c, digit)){//check if digit is present or not 
                return false;//invalid sudoku
            }
            //backtrack
            board[r][c] = digit;//after checking change it to its initial value
        }
        return isValid(board, r, c+1);
    }

    boolean isSafe(char[][] board, int r, int c,
                          int digit)
    {
         //checking row
        for(int i = 0; i<board.length; i++){
            if(board[r][i] == digit){
                return false;
            }
        }

        //checking col
        for(int i = 0; i<board[0].length; i++){
            if(board[i][c] == digit){
                return false;
            }
        }
        //checking box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = r - r%3;
        int colStart = c - c%3;
        for(int row = rowStart; row < rowStart+sqrt; row++){
            for(int col = colStart; col < colStart+sqrt; col++){
                if(board[row][col] == digit){
                    return false;
                }
            }
        }
        return true;
    }


     //Function to find a solved Sudoku. 
    //  static boolean SolveSudoku(int grid[][])
    //  {
    //      //to traverse in 2d matrix
    //      for(int i=0;i<9;i++){
    //          for(int j=0;j<9;j++){
    //              //now we check if ever if encounter a empty bracket
    //              if(grid[i][j]==0){
    //                  //so now like we will try for all possible values from 1-9
    //                  for(int k=1;k<=9;k++){
    //                      //to check if it is valid to put a ch 1-9 here
    //                      if(isValid(grid,i,j,k)){
    //                          //making fill the empty with k if valid
    //                          grid[i][j] = k;
    //                          //recursive call and return true if all good
    //                          if (SolveSudoku(grid)) return true;
    //                          //else backtrack
    //                          else grid[i][j]=0;
                                
    //                      }
                         
    //                  }
    //                  //if we still cant fill the empty blocks return false
    //                  return false;
    //              }
                          
    //          }
    //      }
    //      //if we never encounter any 0 brackets then also return true;
    //      return true;
    //  }
     
    //  private static boolean isValid(int grid[][], int x, int y, int val) {
    //      for(int j = 0; j < grid[0].length; j++) {
    //          if(grid[x][j] == val) {
    //              return false;
    //          }
    //      }
         
    //      for(int i = 0; i < grid.length; i++) {
    //          if(grid[i][y] == val) {
    //              return false;
    //          }
    //      }
         
    //      int smi = x/3 * 3;
    //      int smj = y/3 * 3;
         
    //      for(int i = 0; i < 3; i++) {
    //          for(int j = 0; j < 3; j++) {
    //              if(grid[smi + i][smj + j] == val) {
    //                  return false;
    //              }
    //          }
    //      }
    //      return true;
    //  }
     
    //  //Function to print grids of the Sudoku.
    //  static void printGrid (int grid[][])
    //  {
    //      // add your code here
    //      for(int i = 0; i < grid.length; i++) {
    //          for(int j = 0; j < grid[i].length; j++) {
    //              System.out.print(grid[i][j] + " ");
    //          }
    //      }
    //  }
}
