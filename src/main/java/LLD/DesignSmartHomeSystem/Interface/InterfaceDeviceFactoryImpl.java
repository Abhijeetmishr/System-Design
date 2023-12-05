package LLD.DesignSmartHomeSystem.Interface;

public class InterfaceDeviceFactoryImpl implements InterfaceDeviceFactory{

    @Override
    public InterfaceDevice createInterfaceDevice(String name, String activationKeyword) {
       switch(name.toLowerCase()){
        case "google home":
            return new GoogleHome(name, activationKeyword);
        case "alexa":
            return new Alexa(name, activationKeyword);
        default:
            System.out.println("Unknown Interface Device type: " + name);
            return null;
       }
    }
    
}
