package LLD.MemoryAllocator.entity;

public class MemoryManager {

    String processId;
    String taskId;
    boolean isAllocated;
    
    public MemoryManager(String processId, String taskId, boolean isAllocated) {
        this.processId = processId;
        this.taskId = taskId;
        this.isAllocated = isAllocated;
    }
    public String getProcessId() {
        return processId;
    }
    public void setProcessId(String processId) {
        this.processId = processId;
    }
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public boolean isAllocated() {
        return isAllocated;
    }
    public void setAllocated(boolean isAllocated) {
        this.isAllocated = isAllocated;
    }
    
}
