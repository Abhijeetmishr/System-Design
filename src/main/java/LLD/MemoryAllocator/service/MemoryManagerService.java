package LLD.MemoryAllocator.service;

import java.util.ArrayList;

import LLD.MemoryAllocator.entity.InspectRes;
import LLD.MemoryAllocator.entity.MemoryManager;

public class MemoryManagerService {
   MemoryManager[] memoryManager;
   
   public void initializeMemory(int N){
        this.memoryManager = new MemoryManager[N];
   }

   public void allocateMemory(String processId, String taskId, int noOfBlocks, boolean isContiguos) {
        if(noOfBlocks > 25 || availableSpace() < noOfBlocks) {
            System.out.println("error " + 0 +"/" + availableSpace());
            return;
        }
        
        if(!isContiguos) {
            for(int i = 0; i < 100 && noOfBlocks > 0; i++) {
                if(memoryManager[i] == null) {
                    memoryManager[i] = new MemoryManager(processId, taskId, true);
                }
                noOfBlocks--;
            }
            System.out.println("success " + noOfBlocks + "/" + availableSpace());
        } else {
            int[] index = findContiguosBlock(noOfBlocks);
            for(int i = index[0]; i < index[0] + index[1] && noOfBlocks > 0; i++) {
                memoryManager[i] = new MemoryManager(processId, taskId, true);
                noOfBlocks--;
            }
            System.out.println("success " + noOfBlocks + "/" + availableSpace());
        }
        
   }

   public int availableSpace() {
        int count = 0;
        for(int i = 0; i < 100; i++) {
            if(memoryManager[i] == null){
                count++;
            }
        }
        System.out.println("Count of available spaces: " + count);
        return count;
   }

   public int[] findContiguosBlock(int noOfBlocks) {
    int i = 0;
    int count = 0;
    for(i = 0; i < 100 && count < noOfBlocks; i++, count++) {
        if(memoryManager[i] == null) {
            count++;
        } else {
            count = 0;
            continue;
        }
    }
    return new int[]{i, count};
   }

   public void free(String processId, String taskId) {
    int count = 0;
    for(int i = 0; i < 100; i++) {
        if(memoryManager[i] == null) continue;
        else if(memoryManager[i].getProcessId().equals(processId) && 
                        memoryManager[i].getTaskId().equals(taskId)) {
            memoryManager[i] = null;
            count++;
        }
    }
    System.out.println("success " + count + "/" + availableSpace());
    return;
   }

   public void kill(String processId) {
    int count = 0;
    for(int i = 0; i < 100; i++) {
        if(memoryManager[i] == null) continue;
        else if(memoryManager[i].getProcessId().equals(processId)) {
            memoryManager[i] = null;
            count++;
        }
    }
    System.out.println("success " + count + "/" + availableSpace());
    return;
   }
   
   /**
    public void inspect(String processId){
        ArrayList<InspectRes> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            if(memoryManager[i] == null) continue;
            else if(memoryManager[i].getProcessId().equals(processId)) {
                String taskId = memoryManager[i].getTaskId();
                while(memoryManager[i].getTaskId())
               list.add(new InspectRes(processId, memoryManager[i].getTaskId(), ));
            }
        }
        for(int i = 0; i < list.size(); i++) {

        }
   }
   */
}
