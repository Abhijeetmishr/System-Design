package DSA.Tree.DFS;
/* Leetcode - 1932
You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes,
and no two roots have the same value. In one operation, you can:
    1. Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
    2. Replace the leaf node in trees[i] with trees[j].
    3. Remove trees[j] from trees.
    4. Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.

A BST (binary search tree) is a binary tree where each node satisfies the following property:
    1. Every node in the node's left subtree has a value strictly less than the node's value.
    2. Every node in the node's right subtree has a value strictly greater than the node's value.
    3. A leaf is a node that has no children.

*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MergeBST {
    /*
     * This problem can be broken down into 4 subproblems - 
        1. How to find leave nodes & root nodes in constant time out of n BST
        2. How to find a BST whoes root node is not a leaf node in any one of the BSTs
        3. Given a BST (found in step 2), try to merge rest of BSTs to its left and right child
        4. Find if given tree is BST or not.
    */

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
    // Map to hold leaves
    // It will help to query if any given root not is part of leaves node in any of the BST
    Map<Integer, List<TreeNode> > leaves = new HashMap<>();
    
    // Map to hold roots
    // It will help to query - give me any root node which matches given node 
    // Mostly used for querying for left node matches with any root and right node matches any root
    Map<Integer, TreeNode> roots = new HashMap<>();

    //Function to check if it can be merged or not
    public TreeNode canMerge(List<TreeNode> trees) {
    
        // To queries nodes mulitple times in constant operation we will put them into Map
         for(TreeNode node: trees){
             // append to root map
            roots.put(node.val, node);
             
             // append to leaves map
            if(node.left != null){
                List<TreeNode> nodes = leaves.get(node.left.val);
                if(nodes == null) nodes = new LinkedList<TreeNode>();
                nodes.add(node);
                leaves.put(node.left.val, nodes);
            }
            if(node.right != null){
                List<TreeNode> nodes = leaves.get(node.right.val);
                if(nodes == null) nodes = new LinkedList<TreeNode>();
                nodes.add(node);
                leaves.put(node.right.val, nodes);
            }     
        }

        // find a node which will become root of bst
        TreeNode bstRoot = null;
        for(TreeNode n: trees){
            if(!leaves.containsKey(n.val)){
                bstRoot = n;
                break;
            }
        }
        
        // if no unique root found we cannot merge it
        if(bstRoot == null)
            return null;
        
        // invoke merge operation
        merge(bstRoot);
        
        // at the end we will check only 1 tree should be remaining and it should be BST
        if (roots.size() == 1 && isValidBST(bstRoot, Integer.MIN_VALUE, Integer.MAX_VALUE) )
            return bstRoot;
        
        return null;
            
    }
    
    void merge(TreeNode node){
        if(node == null)
            return;
        if(node.left != null){
            // Find any root node which matches with left leaf node and then append it to my BST
            if(roots.containsKey(node.left.val)){
                node.left = roots.get(node.left.val);
                roots.remove(node.left.val);
            }
        }
        if(node.right != null){
            // Find any root node which matches with right leaf node and then append it to my BST
            // this duplicate code can be reduced by extracting a function
            if(roots.containsKey(node.right.val)){     
                node.right = roots.get(node.right.val);
                roots.remove(node.right.val);
            }
        }
        
        merge(node.left);
        merge(node.right);
    }
    
    boolean isValidBST(TreeNode n, int min, int max){
        if(n.val < min || n.val > max)
            return false;
        
        boolean l =true, r= true;
        
        if(n.left != null)
             l = isValidBST(n.left, min, n.val);
        if(n.right != null)
             r = isValidBST(n.right, n.val, max);
        
        return n.val>min && n.val < max & l && r;
    }
}
