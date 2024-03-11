package DSA.Design;

import java.util.*;

/**
 * https://leetcode.com/problems/lru-cache/solutions/46055/probably-the-best-java-solution-extend-linkedhashmap/
 */
class LRUCache
{
    private Map<Integer, Integer> cache;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int capacity){
        this.cache = new LinkedCappedHashMap<>(capacity);
    }

    //Function to return value corresponding to the key.
    public int get(int key){
        if(!cache.containsKey(key)) return -1;
        else {
            return cache.get(key);
        }
    }

    //Function for storing key-value pair.
    public void put(int key, int value){
      cache.put(key,value);
    }

    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        int max_capacity;
        LinkedCappedHashMap(int capacity){
            super(16,.75f,true);
            this.max_capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest){
            return size() > max_capacity;
        }
    }
}
