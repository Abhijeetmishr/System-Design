package LLD.DesignPatterns.CommandPattern.SmartHome.command;

public class Invoker {
    public void invoke(Command command) {
        command.execute();
    }
}
