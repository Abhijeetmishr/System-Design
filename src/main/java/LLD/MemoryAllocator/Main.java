package LLD.MemoryAllocator;

import java.util.Scanner;

import LLD.MemoryAllocator.service.MemoryManagerService;

public class Main {
    public static void main(String args[]) {
        final String ALLOCATE = "allocate_memory";
        final String FREE = "free";
        final String KILL = "kill";
        final String EXIT = "exit";
        MemoryManagerService processManagerService = new MemoryManagerService();
        processManagerService.initializeMemory(100);
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Enter Command: ");
            String cmd = scan.next();

            switch(cmd){
                case ALLOCATE:
                    processManagerService.allocateMemory(scan.next(), scan.next(), scan.nextInt(), scan.nextBoolean());
                    break;
                case FREE:
                    processManagerService.free(scan.next(), scan.next());
                    break;    
                case KILL:
                    processManagerService.kill(scan.next());  
                    break;  
                case EXIT:
                    return;    
            }
        }
    }
}
