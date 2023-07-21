package LLD.ParkingLot.Models;

public class Vehicle {
    VehicleType vehicleType;
    ParkingSlot parkingSlot;
    String ticketId;
    String vehicleRegistrationNo;
    String color;
    
    public Vehicle(VehicleType vehicleType, ParkingSlot parkingSlot, String vehicleRegistrationNo,
            String color) {
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    
}
