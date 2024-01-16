package DSA.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeBST {
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
    // List<TreeNode> res;
	// public TreeNode getSuccessor(TreeNode a, int b) {
	// 	this.res = new ArrayList<>();
	// 	inorder(a);
	// 	for(int i = 0; i < res.size(); i++){
	// 		if(res.get(i).val == b && i+1 < res.size()){
	// 			return res.get(i+1);
	// 		}
	// 	}
	// 	return null;
	// }
	
	// private void inorder(TreeNode root){
	// 	if(root != null){
	// 		inorder(root.left);
	// 		res.add(root);
	// 		inorder(root.right);
	// 	}
	// }
	public TreeNode getSuccessor(TreeNode A, int B) {
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode node = A;
	        
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        boolean status = false;
		
	    while (!stack.isEmpty()) {
	        node = stack.pop();
	        if (status)
	            return node;
	        
	        if (node.val == B) {
	            status = true;
	        }
	        node = node.right;
	        while (node != null) {
                stack.push(node);
                node = node.left;
            }   
	    }
	    return null;
	}
}
