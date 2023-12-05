package LLD.DesignSmartHomeSystem.Interface;

import LLD.DesignSmartHomeSystem.SmartHome.SmartHomeDevice;

public interface InterfaceDevice {
    void sendCommand(SmartHomeDevice device, String command);
    void recieveResponse(String response);
    String getActivationKeyword();
    String getName();
}
