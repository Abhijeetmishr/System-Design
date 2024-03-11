package LLD.HashMap;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyHashMap<K,V> { 
    private static final int INITIAL_SIZE = 1 << 4; //16
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    
    public Entry[] hashtable;

    public MyHashMap() {
        hashtable = new Entry[INITIAL_SIZE];
    }
    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashtable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @SuppressWarnings("hiding")
    class Entry<K,V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }
   
    public void put(K key, V value) {
        int hashcode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashcode];
        if(node == null){
            Entry newNode = new Entry(key, value);
            hashtable[hashcode] = newNode;
        } else {
            Entry previousNode = node;
            while (node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashCode];
        while(node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "why");
        map.put(2, "do");
        map.put(3, "we");
        map.put(4, "fall");
        map.put(5, "Bruce");
        map.put(6, "?");
        map.put(7, "So");
        map.put(8, "that");
        map.put(9, "we");
        map.put(10, "learn");
        map.put(11, "to");
        map.put(12, "pick");
        map.put(13, "ourselves");
        map.put(14, "up");

        String value = map.get(5);
        System.out.print(value + " Wayne");
    }
}
