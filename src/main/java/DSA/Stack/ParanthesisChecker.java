package DSA.Stack;
import java.util.*;

public class ParanthesisChecker {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
    
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty()) {
                    char st = stack.peek();
                    if(ch == '}' && st == '{' || ch == ')' && st == '(' 
                        || ch == ']' && st == '[') {
                            stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
