package DSA.Tree;
import java.util.*;

public class PostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = right;
            this.right = right;
        }
    }
    public List<Integer> postorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            ans.add(root.val);
        }
        return ans;
    }
}
