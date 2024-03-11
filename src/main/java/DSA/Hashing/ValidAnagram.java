package DSA.Hashing;
import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // if(s.length() != t.length()) return false;
        // for(char ch: s.toCharArray()) {
        //     map.put(ch, map.getOrDefault(ch, 0) + 1);
        // }
        // for(char ch: t.toCharArray()) {
        //     if(!map.containsKey(ch)){
        //         return false;
        //     } else {
        //         if(map.get(ch) == 1){
        //             map.remove(ch);
        //         } else{
        //             map.put(ch, map.get(ch) - 1);
        //         }
        //     }
        // }
        // return true;

        if (s.length() != t.length()) {
            return false;
        }
    
        int[] count = new int[26];
    
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
    
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
    
        return true;
    }
}
