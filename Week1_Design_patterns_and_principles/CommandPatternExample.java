// File: CommandPatternExample.java

public class CommandPatternExample {

    public static void main(String[] args) {
        // Create the receiver
        Light light = new Light();
        
        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        
        // Create the invoker
        RemoteControl remote = new RemoteControl();
        
        // Test turning the light on
        remote.setCommand(lightOn);
        remote.pressButton();
        
        // Test turning the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }

    // Command Interface
    interface Command {
        void execute();
    }

    // Concrete Command to turn on the light
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    // Concrete Command to turn off the light
    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Receiver Class
    static class Light {
        public void turnOn() {
            System.out.println("Light is ON");
        }

        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // Invoker Class
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }
}