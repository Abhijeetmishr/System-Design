package DSA.Tree;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
 * 
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solutions/1666228/pseudo-palindromic-paths-in-a-binary-tree-java-solution-using-dfs/
 */

/*
 The solution to this question is very intuitive, we just need to write the code for Root to Leaf Paths and just check whether any permutation of that path can be a palindrome. For a permutation of a path to be a palindrome, it must satisfy one of the 2 conditions given below:

(i) If the number of nodes in the path is even, then the frequency of each node's value in that path must be even.

(ii) If the number of nodes in the path is odd, then the frequency of atmost one node's value in that path must be odd.

*/
public class PseudoPalindrome {
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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        dfsUtil(root, map);
        return count;
    }

    public void dfsUtil(TreeNode root, int[] map){
        if(root == null){
            return; 
        }
        map[root.val] = map[root.val] + 1;

        if(root.left == null && root.right == null){
            if(isPseudoPalindrome(map)){
                count++;
            }
        }
        dfsUtil(root.left, map);
        dfsUtil(root.right, map);

        //backtrack
        map[root.val] = map[root.val] - 1;
    }

    public boolean isPseudoPalindrome(int[] map){
        int miss = 0;
        for(int i = 0; i <= 9; i++){
            if(map[i]%2 != 0){
                miss++;
            }
            if(miss > 1) return false;
        }
        return true;
    }
}
