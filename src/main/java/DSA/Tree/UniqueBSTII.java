package DSA.Tree;
import java.util.*;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *  
 *  Example 1:
 *  Input: n = 3
    Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

    Example 2:
    Input: n = 1
    Output: [[1]]
 */
public class UniqueBSTII {

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

    public List<TreeNode> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(s > e){
            res.add(null);
            return res;
        }

        for(int i = s; i <= e; i++){
            List<TreeNode> leftSubtrees = generateSubtrees(s, i-1);
            List<TreeNode> rightSubtrees = generateSubtrees(i+1, e);

            for(TreeNode left : leftSubtrees){
                for(TreeNode right: rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
