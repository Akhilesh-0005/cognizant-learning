// ── Receiver Class ──
class Light {
    private final String location;
    public Light(String location) { this.location = location; }
    public void turnOn()  { System.out.println(location + " light is ON"); }
    public void turnOff() { System.out.println(location + " light is OFF"); }
}

// ── Command Interface ──
interface Command {
    void execute();
}

// ── Concrete Commands ──
class LightOnCommand implements Command {
    private final Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute()              { light.turnOn(); }
}

class LightOffCommand implements Command {
    private final Light light;
    public LightOffCommand(Light light) { this.light = light; }
    public void execute()               { light.turnOff(); }
}

// ── Invoker Class ──
class RemoteControl {
    private Command command;

    public void setCommand(Command command) { this.command = command; }

    public void pressButton() {
        if (command == null) throw new IllegalStateException("No command set.");
        command.execute();
    }
}

// ── Test Class ──
public class CommandPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern — Home Automation ===\n");

        Light livingRoom = new Light("Living Room");
        Light bedroom    = new Light("Bedroom");

        Command livingRoomOn   = new LightOnCommand(livingRoom);
        Command livingRoomOff  = new LightOffCommand(livingRoom);
        Command bedroomOn      = new LightOnCommand(bedroom);
        Command bedroomOff     = new LightOffCommand(bedroom);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomOn);  remote.pressButton();
        remote.setCommand(bedroomOn);     remote.pressButton();
        remote.setCommand(livingRoomOff); remote.pressButton();
        remote.setCommand(bedroomOff);    remote.pressButton();

        System.out.println("\nCommand Pattern implemented successfully.");
    }
}
