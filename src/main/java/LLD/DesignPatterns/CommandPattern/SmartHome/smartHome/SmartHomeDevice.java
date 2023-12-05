package LLD.DesignPatterns.CommandPattern.SmartHome.smartHome;

public interface SmartHomeDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}
