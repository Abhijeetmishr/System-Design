package DSA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import DSA.Backtracking.WordSearch;

public class Main {
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
            WordSearch wordSearch = new WordSearch();
            // Print the LCS to the console (and it will be redirected to the file)
            System.out.println("doesExist: " + WordSearch.exist(list, B));
            
            // Reset System.out to the original output stream (console)
            System.setOut(originalOut);

            // Close the file output stream
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
