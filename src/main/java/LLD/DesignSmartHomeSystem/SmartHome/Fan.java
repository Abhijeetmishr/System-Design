package LLD.DesignSmartHomeSystem.SmartHome;

public class Fan implements SmartHomeDevice{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Fan turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Fan turned off.");
    }

    @Override
    public String getStatus() {
        return isOn ? "On" : "Off";
    }

    
}
