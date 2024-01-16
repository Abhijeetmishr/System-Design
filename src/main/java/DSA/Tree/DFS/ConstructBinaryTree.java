package DSA.Tree.DFS;

import java.util.*;

//Idea is to use divide and conquer
//store all the inorder in hashmap
//iterate over preorder/postorder and find pos of root in inorder 
//iterate for preorder from 0 to n
    // call for 0 to pos-1 && and store in root.left
    //call for pos to n-1 && and store in root.right
public class ConstructBinaryTree {
    int[] preorder;
    int[] postorder;
    int curr;
    Map<Integer,Integer> positions;

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

    //Driver class
    public TreeNode buildTreeNode1(int[] preorder, int[] inorder){
        this.curr = 0;
        this.preorder = preorder;
        this.positions = new HashMap<>();
        int n = inorder.length;

        for(int i = 0; i < n; i++){
            positions.put(inorder[i], i);
        }
        TreeNode root = buildTree1(0, n-1);
        return root;

        // this.curr = n-1;
        // this.postorder = postorder;
        // this.positions = new HashMap<>();
        // int n = inorder.length;
        // for(int i = 0; i < n; i++) {
        //     positions.put(inorder[i], i);
        // }
        // TreeNode root = buildTree2(0, n-1);
        // return root;
    }

    // Recursive solution for constructing binary tree using postorder and inorder traversal
    private TreeNode buildTree2(int start, int end){
        if(start > end)
            return null;
        TreeNode root = new TreeNode(postorder[curr]);
        int pos = positions.get(postorder[curr--]);
        root.right = buildTree2(pos+1, end);
        root.left = buildTree2(start, pos-1);
        return root;
    }
     // Recursive solution for constructing binary tree using preorder and inorder traversal
    private TreeNode buildTree1(int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[curr]);
        int pos = positions.get(preorder[curr++]);
        node.left = buildTree1(start, pos-1);
        node.right = buildTree1(pos+1, end);
        return node;
    }
}
