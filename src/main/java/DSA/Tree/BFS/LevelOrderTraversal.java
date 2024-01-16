package DSA.Tree.BFS;
import java.util.*;

public class LevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> ans = new ArrayList<>();
            while(len-- > 0){
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left); 
                if(curr.right != null)
                    q.add(curr.right);                
            }
            res.add(ans);
        }
        return res;
    }
}
