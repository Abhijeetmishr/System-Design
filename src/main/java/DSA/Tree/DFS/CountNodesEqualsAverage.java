package DSA.Tree.DFS;

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */
public class CountNodesEqualsAverage {
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
    private int res;
    public int averageOfSubtree(TreeNode root) {
        this.res =0;
        inorder(root);
        return res;
    }
    private int[] inorder(TreeNode root) {
        if(root != null){
            int[] left = inorder(root.left);
            int[] right = inorder(root.right);
            
            int currSum = left[0] + right[0] + root.val;
            int currCount = left[1] + right[1] + 1;

            if(root.val == currSum/currCount){
                res++;
            }
            return new int[]{currSum, currCount};
        }
        return new int[]{0, 0};
    }
}
