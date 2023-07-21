package LLD.ParkingLot;

import java.util.Scanner;

import LLD.ParkingLot.Models.DisplayType;
import LLD.ParkingLot.Models.ParkingLot;
import LLD.ParkingLot.Models.VehicleType;
import LLD.ParkingLot.service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("PR1234", 2, 6);
        ParkingLotService parkingLotService = new ParkingLotService();
        final String CREATE_PARKING_LOT= "create_parking_lot";
        final String DISPLAY= "display";
        final String PARK_VEHICLE = "park_vehicle";
        final String UNPARK_VEHICLE = "unpark_vehicle";
        final String EXIT = "exit";

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Command: ");
            String cmd = scanner.next();

            switch(cmd) {
                case CREATE_PARKING_LOT: 
                    parkingLotService.createParkingLot(parkingLot);
                    break;
                case DISPLAY:
                    parkingLotService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE);
                    break;  
                case PARK_VEHICLE:
                    parkingLotService.parkVehicle(VehicleType.BIKE, scanner.next(), scanner.next());
                    break;
                case UNPARK_VEHICLE:
                    parkingLotService.unParkVehicle(scanner.next());
                    break;  
                case EXIT: return;           
            }
        }
        
    }
}
