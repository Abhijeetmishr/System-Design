package DSA.Tree;

/**
 * You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBST {
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

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
       inorder(root);

       int temp = first.val;
       first.val = second.val;
       second.val = temp;
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);

            if(first == null && root.val < prev.val)
                first = prev;
            if(first != null && root.val < prev.val)
                second = root;
            prev = root;

            inorder(root.right);
        }
        return;
    }
}
