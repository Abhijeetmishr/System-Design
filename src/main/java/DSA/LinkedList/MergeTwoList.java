package DSA.LinkedList;

public class MergeTwoList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1!=null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while(curr1 != null && curr2 != null) {
            if(curr1.val > curr2.val) {
                prev.next = curr2;
                curr2 = curr2.next;
            } else {
                prev.next = curr1;
                curr1 = curr1.next;
            }
            prev = prev.next;
        }
        prev.next = curr1 != null ? curr1 : curr2;

        return dummy.next;
    }
}
