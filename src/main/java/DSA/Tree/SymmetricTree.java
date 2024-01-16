package DSA.Tree;
import java.util.*;

public class SymmetricTree {
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
    //Iterative
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    // Recursive solution
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null) return true;
    //     return isTreeSymmetric(root.left, root.right);
    // }

    // public boolean isTreeSymmetric(TreeNode leftRoot, TreeNode rightRoot){
    //     if(leftRoot == null && rightRoot == null) 
    //         return true;
    //     if(leftRoot == null || rightRoot == null)
    //         return false;
    //     if(leftRoot.val != rightRoot.val)
    //         return false;
    //     return isTreeSymmetric(leftRoot.left, rightRoot.right) && 
    //         isTreeSymmetric(leftRoot.right, rightRoot.left);
    // }
}
