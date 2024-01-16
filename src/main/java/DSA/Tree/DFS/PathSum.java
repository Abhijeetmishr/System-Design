package DSA.Tree.DFS;
import java.util.*;

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Recursive solution
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(root == null) return false;
    //     if(root.left == null && root.right == null && root.val == targetSum)
    //         return true;
    //     return hasPathSum(root.left, targetSum - root.val) || 
    //          hasPathSum(root.right, targetSum - root.val);
    // }

    //Iterative 
    /** 
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        stack.push(root);
        sum.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currSum = sum.pop();
            if (currSum == targetSum && node.left == null && node.right == null)
                return true;
            
            if (node.right != null) {
                stack.push(node.right);
                sum.push(node.right.val + currSum);
            }
            if (node.left != null) {
                stack.push(node.left);
                sum.push(node.left.val + currSum);
            }
        }
        return false;
    }
    */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        queue.add(root);
        sum.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int currSum = sum.remove();
                if (currSum == targetSum && node.left == null && node.right == null) {
                    return true;
                }
                
                
               if (node.left != null) {
                    queue.add(node.left);
                    sum.add(node.left.val + currSum);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum.add(node.right.val + currSum);
                }
            }
        }
        return false;
    }
}
