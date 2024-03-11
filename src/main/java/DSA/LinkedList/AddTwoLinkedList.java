package DSA.LinkedList;

public class AddTwoLinkedList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;

       ListNode curr1 = l1;
       ListNode curr2 = l2;
       ListNode ans = new ListNode(-1);
       ListNode itr = ans;
       int carry = 0;

       while(curr1 != null || curr2 != null || carry != 0) {
           int sum = carry + (curr1 != null ? curr1.val : 0) 
                            + (curr2 != null ? curr2.val : 0);
           int digit = sum % 10;
           carry = sum / 10;
           itr.next = new ListNode(digit);
           itr = itr.next;
           if(curr1 != null) curr1 = curr1.next;
           if(curr2 != null) curr2 = curr2.next;                 
       }
       return ans.next;
    }
}
