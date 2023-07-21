package LLD.MemoryAllocator.entity;

public class InspectRes {
    String processId;
    String taskId;
    int start;
    int end;
    public InspectRes(String processId, String taskId, int start, int end) {
        this.processId = processId;
        this.taskId = taskId;
        this.start = start;
        this.end = end;
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
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    
}
