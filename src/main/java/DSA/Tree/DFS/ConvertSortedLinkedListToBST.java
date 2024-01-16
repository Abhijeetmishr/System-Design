package DSA.Tree.DFS;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
    height-balanced
    binary search tree.

    Example 1:
    Input: head = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

    Example 2:
    Input: head = []
    Output: []
*/

public class ConvertSortedLinkedListToBST {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }    

    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode fast = head;
        ListNode slow = head;

        if(head==tail) return null;
        
        while(fast.next != tail && fast != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}
