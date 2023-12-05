package DSA.String;

public class ZigZagConversion {
    /*
     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
     (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        
        And then read line by line: "PAHNAPLSIIGYIR"    
    */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        String ans = "";

        for(int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows-1);
            for(int i = r; i < s.length(); i = i + increment) {
                ans += s.charAt(i);
                if(r > 0 && r < numRows - 1 && i + increment - 2*r < s.length()) {
                    ans += s.charAt(i + increment - 2*r);
                }
            }
        }
        return ans;
    }
}
