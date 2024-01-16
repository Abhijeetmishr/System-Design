package DSA.LinkedList;

import java.util.PriorityQueue;

/*
 * Example 1:

    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
 * 
 */
class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for(ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while(pq.size() != 0){
            ListNode node = pq.remove();
            prev.next = node;
            prev = prev.next;
            node = node.next;
            if(node != null)
                pq.add(node);
        }
        return dummyNode.next;
    }

    /** Based on merge sort
     * public ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
    */
}
