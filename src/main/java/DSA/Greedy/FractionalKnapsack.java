package DSA.Greedy;
import java.util.*;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        public Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new ItemComparator());

	    double  res = 0.0;
        
        for(int  i = 0; i < n; i++) {
            if(W >= arr[i].weight) {
                res += arr[i].value;
                W = W - arr[i].weight;
            } else {
                res += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }
        return res;
    }
    
    static class ItemComparator implements Comparator<Item>{
		public int compare(Item a, Item b){
            return a.weight*b.value - a.value*b.weight;
        }
	}
}
