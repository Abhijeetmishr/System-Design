package LLD.DesignPatterns.CommandPattern.SmartHome.command;

import LLD.DesignSmartHomeSystem.SmartHome.Light;

public class ColourCommand extends SmartHomeCommand{
    public ColourCommand(Light smartHomeDevice, String commandString) {
        super(smartHomeDevice, commandString);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        Light light = (Light) smartHomeDevice;
        try {
            light.setColor(commandString);
        } catch (UnknownColorException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------");
    }
}
