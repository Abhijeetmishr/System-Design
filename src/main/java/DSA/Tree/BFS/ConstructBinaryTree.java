package DSA.Tree.BFS;

import java.util.*;

public class ConstructBinaryTree {
    
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
    // Iterative Solution construct binary tree using preorder and inorder traversal
    public TreeNode buildTreeNode1(int[] preorder, int[] inorder) {
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inOrderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for(int i = 1; i < preorder.length; i++){
            TreeNode prev = null;
            while(!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]){
                prev = stack.pop();
                inOrderIndex++;
            }

            TreeNode toInsert = new TreeNode(preorder[i]);

            if(prev == null){
                prev = stack.peek();
                prev.left = toInsert;
            } else {
                prev.right = toInsert;
            }
            stack.push(toInsert);
        }
        return root;
    }

    // Iterative Solution construct binary tree using postorder and inorder traversal
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n-1]);
        int inorderIndex = n-1;
        stack.push(root);
            
        for(int i = n-2; i >= 0; i--){
            TreeNode prev = null;
            while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                prev = stack.pop();
                inorderIndex--;
            }
            TreeNode toInsert = new TreeNode(postorder[i]);
            if(prev == null){
                prev = stack.peek();
                prev.right = toInsert;
            }
            else{
                prev.left = toInsert;
            }
            stack.push(toInsert);
        }
        return root;   
    }   
}
