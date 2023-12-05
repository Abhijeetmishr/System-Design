## Design Smart Home System

    - Requirements
    - APIs
    - Classes
    - Extend & Iterate

## Requirements

**An Interface device**

- alexa
- google
  
**A Smart Home Device**

- General electric devices
  - can be turned on/off
- Bulb
  - can be turned on/off
  - increase and decrease brightness on scale of 1 to 10
- Fan
  - can be turned on/off
  - increase and decrease speed on scale of 1 to 5

- A Home can have one or more Interface.
- A Home can have one or more devices.
- 1 SmartHome device can be connected to 1 interfaces.

## Requirements: Debrief

- Add 1 or more interface devices.
- Add 1 or more SmartHome Devices with a default Interface Device they are connected to
- User should be able to send a command to any SmartHome device via a Connected Interface device by using Activation Keyword(Ex: “OK Google”)
  
- SmartHome device can respond to the command as follows:
  - Can only accept a valid command and change its internal state
  - Can reject an invalid command with appropriate message to the interface device
  
- Interface device should provide all connected devices and their status
- User should be able to connect or disconnect a SmartHome device to an interface device.

## APIs

- boolean Interface(String name, String location, String activation_keyword);
- boolean device(String interface, String device, String location);
- String give_command(String activation_keyword, String deviceName, Location location, String commandValue);
- print_devices_status(String device, String interface, String location);
- connect_smarthome_device(String interface, String device, String location);
- disconnect_smarthome_device(String interface, String device, String location);

## Classes

| Header 1 | Header 2 |
| -------- | -------- |
| Cell 1   | Cell 2   |
