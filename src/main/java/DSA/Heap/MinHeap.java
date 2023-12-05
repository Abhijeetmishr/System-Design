package DSA.Heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int c){
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    int left(int i){return (2*i+1);}
    int right(int i){return (2*i+2);}
    int parent(int i){return (i-1)/2;}

    void insert(int x){
        if(size == capacity) return;
        size++; arr[size-1] = x;
        int i = size-1;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(arr[i], arr[parent(i)]);
            i = parent(i);
        }
    }
    //Time Complexity - O(log n)
    void minHeapify(int i){
        int lt = left(i), rt = right(i);

        int smallest = i;
        if(lt < size && arr[lt] < arr[i]){
            smallest = lt;
        }
        if(rt < size && arr[rt] < arr[smallest]){
            smallest = rt;
        }

        if(smallest != i){
            swap(arr[i], arr[smallest]);
            minHeapify(smallest);
        }
    }
    
    //remove the minimum element
    //Time cmplexity O(log n)
    int extractMin(){
        if(size == 0) return Integer.MAX_VALUE;
        if(size == 1) {
            size--;
            return arr[0];
        }
        swap(arr[0], arr[size-1]);
        size--;
        minHeapify(0);
        return arr[size];
    }

    void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
