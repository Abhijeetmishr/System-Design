package DSA.LinkedList;
/**
 * check if LinkedList is palindrome
 * 1->2->1
 */
public class PalindromeLinkedList {
    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        Node itr = reverseLinkedList(slow);

        while(itr != null){
            if(itr.val != fast.val){
                return false;
            }
            itr = itr.next;
            fast = fast.next;
        }
        return true;
    }

    public Node reverseLinkedList(Node slow){
        Node curr = slow;
        Node prev = null;
        
        while(curr != null){
            Node Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

}
