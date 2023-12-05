package LLD.DesignSmartHomeSystem.SmartHome;

public class Light implements SmartHomeDevice{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light turned off.");
    }

    @Override
    public String getStatus() {
        return isOn ? "On" : "Off";
    }
    
}
