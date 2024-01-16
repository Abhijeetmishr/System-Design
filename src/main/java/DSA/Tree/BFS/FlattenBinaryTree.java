package DSA.Tree.BFS;
import java.util.*;

public class FlattenBinaryTree {
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
    Queue<TreeNode> q;
    public void flatten(TreeNode root) {
        if(root == null) return;
        this.q = new LinkedList<>();
        preorder(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            node.left = null;
            if(!q.isEmpty()){
                node.right = q.peek();
            } else {
                node.right = null;
            }
        }
    }

    private void preorder(TreeNode root){
        if(root != null){
            q.add(root);
            preorder(root.left);
            preorder(root.right);
        }
        return;
    }
}
