package Java.Advance.Concurrency;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {

    // Using Concurrent HashMap
    Map<Integer, String> hashMap = new ConcurrentHashMap<>();

    // Creating 2 threads to modify the hashmap concurrently
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        hashMap.put(i, "Thread1-" + i);
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 1000; i < 2000; i++) {
        hashMap.put(i, "Thread2-" + i);
      }
    });

    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print the size of the HashMap
    System.out.println("HashMap size: " + hashMap.size());

  }
}
