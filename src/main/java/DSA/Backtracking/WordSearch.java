package DSA.Backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearch {
    static char[][] board;
    static int row, col;
    public static int exist(ArrayList<String> A, String word) throws FileNotFoundException {
        row = A.size();
        col = A.get(0).length();
        board = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = A.get(i).charAt(j);
            }
        }
        if(board.length == 0 || word.length() == 0) return 1;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && dfs(board, i, j, 0, word)){
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean dfs(char[][] board, int i, int j, int start, String word) {
        if(start == word.length())
            return true;
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(start)){
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        
        if(dfs(board, i+1, j, start+1, word) || 
            dfs(board, i-1, j, start+1, word) ||
            dfs(board, i, j+1, start+1, word) ||
            dfs(board, i, j-1, start+1, word))
            return true;

        board[i][j] = ch;
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\akmap\\Documents\\System-Design\\src\\main\\java\\DSA\\input.txt"));
            ArrayList<String> list = new ArrayList<>();
            int size = sc.nextInt();
            for(int i = 0; i < size; i++){
                String A = sc.nextLine();
                list.add(A);
            }
            
            String B = sc.nextLine();

            // Redirect output to a file
            PrintStream originalOut = System.out;
            PrintStream fileOut = new PrintStream("C:\\Users\\akmap\\Documents\\System-Design\\src\\main\\java\\DSA\\output.txt");
            System.setOut(fileOut);
            // Print the LCS to the console (and it will be redirected to the file)
            System.out.println("doesExist: " + exist(list, B));
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            // Reset System.out to the original output stream (console)
            System.setOut(originalOut);

            // Close the file output stream
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
