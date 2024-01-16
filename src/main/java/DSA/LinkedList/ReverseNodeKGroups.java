package DSA.LinkedList;
/*
 *  Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
 */
public class ReverseNodeKGroups {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode temp = head;
        
    }
}
