package DSA.Tree;
import java.util.*;
public class MaxDepthBinaryTree {
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
    public int maxDepth(TreeNode root) {
        //DFS Approach
        // if(root == null) return 0;
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        //BFS Approach
        if(root==null) return 0;
        Queue<TreeNode> que =new LinkedList<>();
        que.add(root);
        // For Counting
        int ans=0;
        while(!que.isEmpty()){
            int level=que.size();
            for(int i=0;i<level;i++){
                    if(que.peek().left!=null) que.add(que.peek().left);
                    if(que.peek().right!=null) que.add(que.peek().right);
                    que.poll();
            }
            // Increment
            ans++;
        }
        return ans;
    }
}
