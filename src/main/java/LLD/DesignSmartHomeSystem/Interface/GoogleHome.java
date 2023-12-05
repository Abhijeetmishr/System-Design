package LLD.DesignSmartHomeSystem.Interface;

import LLD.DesignSmartHomeSystem.SmartHome.SmartHomeDevice;

public class GoogleHome implements InterfaceDevice{
    private String name;
    private String activationKeyword;

    GoogleHome(String name, String activationKeyword){
        this.name = name;
        this.activationKeyword = activationKeyword;
    }

    @Override
    public void sendCommand(SmartHomeDevice device, String command) {
        System.out.println(name + " sending command: " + command);
        if("On".equalsIgnoreCase(command)){
            device.turnOn();
        } else if("off".equalsIgnoreCase(command)){
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
        return "Google Home";
    }
    
}
