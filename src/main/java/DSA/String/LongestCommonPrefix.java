package DSA.String;

public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if(strs == null || strs.length == 0) {
            return longestCommonPrefix;
        }
        int index = 0;
        for(char ch : strs[0].toCharArray()){
            for(int i = 0; i < strs.length; i++) {
                if(index >= strs[i].length() || ch != strs[i].charAt(index)) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += ch;
            index++;
        }
        return longestCommonPrefix;
    }
    
}
