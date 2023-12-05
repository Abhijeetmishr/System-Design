package LLD.DesignPatterns.CommandPattern.SmartHome.command;

import LLD.DesignPatterns.CommandPattern.SmartHome.smartHome.SmartHomeDevice;

public abstract class SmartHomeCommand implements Command{
    SmartHomeDevice smartHomeDevice;
    String commandString;

    public SmartHomeCommand(SmartHomeDevice smartHomeDevice, String commandString){
        this.smartHomeDevice = smartHomeDevice;
        this.commandString = commandString;
    }

    public SmartHomeCommand(SmartHomeDevice smartHomeDevice){
        this.smartHomeDevice = smartHomeDevice;
    }
}
