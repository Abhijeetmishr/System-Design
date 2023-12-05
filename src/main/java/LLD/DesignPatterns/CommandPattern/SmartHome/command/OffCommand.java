package LLD.DesignPatterns.CommandPattern.SmartHome.command;

public class OffCommand extends SmartHomeCommand {
    public OffCommand(GenericElectricDevice device) {
        super(device);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        GenericElectricDevice device = (GenericElectricDevice) smartHomeDevice;
        device.setOnOffStatus(Boolean.FALSE);
        System.out.println(device);
        System.out.println("----------------------------------------------");
    }
}
