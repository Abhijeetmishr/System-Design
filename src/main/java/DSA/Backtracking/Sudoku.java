package DSA.Backtracking;

public class Sudoku {
     //Function to find a solved Sudoku. 
     static boolean SolveSudoku(int grid[][])
     {
         //to traverse in 2d matrix
         for(int i=0;i<9;i++){
             for(int j=0;j<9;j++){
                 //now we check if ever if encounter a empty bracket
                 if(grid[i][j]==0){
                     //so now like we will try for all possible values from 1-9
                     for(int k=1;k<=9;k++){
                         //to check if it is valid to put a ch 1-9 here
                         if(isValid(grid,i,j,k)){
                             //making fill the empty with k if valid
                             grid[i][j] = k;
                             //recursive call and return true if all good
                             if (SolveSudoku(grid)) return true;
                             //else backtrack
                             else grid[i][j]=0;
                                
                         }
                         
                     }
                     //if we still cant fill the empty blocks return false
                     return false;
                 }
                          
             }
         }
         //if we never encounter any 0 brackets then also return true;
         return true;
     }
     
     private static boolean isValid(int grid[][], int x, int y, int val) {
         for(int j = 0; j < grid[0].length; j++) {
             if(grid[x][j] == val) {
                 return false;
             }
         }
         
         for(int i = 0; i < grid.length; i++) {
             if(grid[i][y] == val) {
                 return false;
             }
         }
         
         int smi = x/3 * 3;
         int smj = y/3 * 3;
         
         for(int i = 0; i < 3; i++) {
             for(int j = 0; j < 3; j++) {
                 if(grid[smi + i][smj + j] == val) {
                     return false;
                 }
             }
         }
         return true;
     }
     
     //Function to print grids of the Sudoku.
     static void printGrid (int grid[][])
     {
         // add your code here
         for(int i = 0; i < grid.length; i++) {
             for(int j = 0; j < grid[i].length; j++) {
                 System.out.print(grid[i][j] + " ");
             }
         }
     }
}
