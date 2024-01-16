package DSA.Tree;
import java.util.*;
/**
 * Time Complexity - O(N)
 * Space Complexity - O(1)
 * https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/1442463/o-1-space-morris-traversal-v-imp-for-interviews-with-java-code-and-detailed-explanation/
 */
public class MorrisInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
            TreeNode leftNode = curr.left;
            if(leftNode == null){
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    private TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr){
        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
