package LLD.DesignSmartHomeSystem.Interface;

import LLD.DesignSmartHomeSystem.SmartHome.SmartHomeDevice;

public class Alexa implements InterfaceDevice{
    private String name;
    private String activationKeyword;

    public Alexa(String name, String activationKeyword){
        this.name = name;
        this.activationKeyword = activationKeyword;
    }
    @Override
    public void sendCommand(SmartHomeDevice device, String command) {
        System.out.println(name + " sending command: " + command);
        if ("On".equalsIgnoreCase(command)) {
            device.turnOn();
        } else if ("Off".equalsIgnoreCase(command)) {
            device.turnOff();
        } else {
            System.out.println("Invalid command.");
        }
    }

    @Override
    public void recieveResponse(String response) {
        System.out.println(name + " received response: " + response);
    }

    @Override
    public String getActivationKeyword() {
        return activationKeyword;
    }

    @Override
    public String getName() {
        return "Alexa";
    }
    
}
