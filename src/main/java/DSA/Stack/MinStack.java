package DSA.Stack;
import java.util.*;

public class MinStack {
    ArrayList<Integer> list;
    PriorityQueue<Integer> pq;
    public MinStack() {
        list = new ArrayList<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        list.add(val);
        pq.offer(val);
    }
    
    public void pop() {
        int n = list.get(list.size() - 1);
        list.remove(list.size() - 1); 
        pq.remove(n);
    }
    
    public int top() {
        if(list.size() == 0) return -1;
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        if(pq.size() == 0) {
            return -1;
        }
        return pq.peek();
    }
}
