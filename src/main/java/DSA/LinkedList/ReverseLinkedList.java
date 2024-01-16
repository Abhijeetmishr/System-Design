package DSA.LinkedList;

public class ReverseLinkedList {
    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
    public Node reverseLinkedList(Node head){
        if(head == null) return null;
        if(head.next == null){
            return head;
        }

        Node curr = head;
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
