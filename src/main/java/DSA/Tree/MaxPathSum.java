package DSA.Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxPathSum {
    int[] ans;
    public class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //  DFS
    // public int maxPathSum(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     ans = new int[1];
    //     ans[0] = root.val;
    //     dfs(root);
    //     return ans[0];
    // }

    // public int dfs(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     int leftMax = dfs(root.left);
    //     int rightMax = dfs(root.right);
    //     leftMax = Math.max(leftMax, 0);
    //     rightMax = Math.max(rightMax, 0);
    //     /**compute max path sum WITH split */
    //     ans[0] = Math.max(ans[0], root.val + leftMax + rightMax);
    //     /**WITHOUT Split */
    //     return root.val + Math.max(leftMax, rightMax);
    // }

    //Iterative approach
    public Iterable<TreeNode> topSort(TreeNode root) {
        Deque<TreeNode> result = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                result.push(curr);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
        return result;
    }

    public int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
        maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
        for (TreeNode node : topSort(root)) {
            // as we process nodes in post-order their children are already cached
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0); 
            maxRootPath.put(node, Math.max(left, right) + node.val);
            result = Math.max(left + right + node.val, result);
        }
        return result;
    }

}
