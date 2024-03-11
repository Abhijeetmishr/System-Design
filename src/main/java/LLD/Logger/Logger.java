package LLD.Logger;
import java.util.*;

public class Logger implements ILogger {
    class Node {
        String pid;
        Long start_time;
        Long end_time;
        Node(String pid, Long start_time, Long end_time){
            this.pid = pid;
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }

    Map<String,Long> startMap = new HashMap<>();
    PriorityQueue<Node> minHeap= new PriorityQueue<>((node1, node2) -> Long.compare(node1.start_time, node2.start_time));

    @Override
    public void start(String processId, long startTime) {
        startMap.put(processId, startTime);
    }

    @Override
    public void end(String processId, long endTime) {
       if(!startMap.containsKey(processId)){
            throw new IllegalArgumentException("processId doesnot exist");
       }
       Node node = new Node(processId, startMap.get(processId), endTime);

       startMap.remove(processId);

       minHeap.offer(node);
    }

    @Override
    public void print() {
       while (!minHeap.isEmpty()) {
            Node process = minHeap.poll();
            System.out.println(process.pid + " started at " + process.start_time + " and ended at " + process.end_time);
        }
    }
    

}
