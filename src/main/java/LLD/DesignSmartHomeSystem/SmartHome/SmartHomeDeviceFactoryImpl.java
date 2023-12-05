package LLD.DesignSmartHomeSystem.SmartHome;

public class SmartHomeDeviceFactoryImpl implements SmartHomeDeviceFactory{

    @Override
    public SmartHomeDevice createSmartHomeDevice(String deviceType) {
       switch(deviceType.toLowerCase()){
        case "light":
            return new Light();
        case "fan":
            return new Fan();
        default:
            System.out.println("Unknown smart home device type: " + deviceType);
            return null;
       }
    }
    
}
