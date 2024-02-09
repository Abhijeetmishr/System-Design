package DSA.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.

    A mapping of digits to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
 */
public class LetterCombination {
    HashMap<Character, String> map;
    public void combinations(List<String> res, String digits, String ans, int index){
        if(index >= digits.length()){
            res.add(ans);
            return;
        }

        for(int i = 0; i < map.get(digits.charAt(index)).length(); i++){
            char ch = map.get(digits.charAt(index)).charAt(i);
            combinations(res, digits, ans+ch, index+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        map = new HashMap<>();
        List<String> res = new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        combinations(res, digits, "", 0);
        return res;
    }
}
