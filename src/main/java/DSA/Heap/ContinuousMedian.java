package DSA.Heap;

import java.util.*;
/*
 * https://leetcode.com/problems/find-median-from-data-stream/submissions/1085778166/?envType=study-plan-v2&envId=top-interview-150
 */
class ContinuousMedian {
	
	public static ArrayList<Integer> continuousMedian(ArrayList<Integer> nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Integer> min_heap = new PriorityQueue<>((a, b) -> a-b);
		PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b) -> b-a);

		for(int num : nums){
			if(max_heap.isEmpty() || max_heap.peek() > num){
				max_heap.add(num);
			} else {
				min_heap.add(num);
			}
			balanceHeap(min_heap, max_heap);
			findMedian(min_heap, max_heap, result);
		}
        return result;

	}

	public static void balanceHeap(PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap){
		if(max_heap.size() > min_heap.size() + 1){
			min_heap.add(max_heap.poll());
		} else if(min_heap.size() > max_heap.size()) {
           max_heap.add(min_heap.poll());
       }
	}

	public static void findMedian(PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap, ArrayList<Integer> result){
		if(max_heap.size() == min_heap.size()){
			result.add((min_heap.peek() + max_heap.peek())/2);
		} else {
			result.add(max_heap.peek());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		for ( int i = 0; i < n; i++) {
			int x = sc.nextInt();
			A.add(x);
		}

		ArrayList<Integer> answer = continuousMedian(A);
		for ( int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i) + " ");
		}

	}
}
