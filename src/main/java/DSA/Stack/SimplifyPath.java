package DSA.Stack;
import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;

        
        // Stack<String> stack = new Stack<>();
        // String[] pathArray = path.split("/");

        // for (String s : pathArray) {
        //     if (s.equals("..")) {
        //         if (!stack.isEmpty()) {
        //             stack.pop();
        //         }
        //     } else if (s.length() != 0 && !s.equals(".")) {
        //         stack.push(s);
        //     }
        // }

        // StringBuilder res = new StringBuilder();
        // while (!stack.isEmpty()) {
        //     res.insert(0, "/" + stack.pop());
        // }

        // return res.toString().length() > 0 ? res.toString() : "/";
    }
}
