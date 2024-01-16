package DSA.Tree.BFS;
import java.util.*;

public class ZigZagTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Boolean zigZag = true;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);         
            }
            if(zigZag == false){
                Collections.reverse(ans);
            }
            res.add(ans);
            zigZag = !zigZag;
        }
        return res;
    }
}
