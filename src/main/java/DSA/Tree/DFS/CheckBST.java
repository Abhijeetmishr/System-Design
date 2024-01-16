package DSA.Tree.DFS;

public class CheckBST {
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

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return checkBST(root, min, max);
    }

    public boolean checkBST(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max)
            return false;
        return (checkBST(root.left, min, root.val) && 
            checkBST(root.right, root.val, max));
    }
    
    // TreeNode prev = null;
    // public boolean isBST(TreeNode root) {
    //     if(root != null) {
    //         if(!isBST(root.left))
    //             return false;
    //         if(prev != null && root.val <= prev.val)
    //             return false;
    //         prev = root;
    //         return isBST(root.right);
    //     }
    //     return true;
    // }
}
