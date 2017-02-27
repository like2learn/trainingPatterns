package com.e16.training.command;

public class FlipUpCommand implements Command {
    private Light theLight;

    public FlipUpCommand(final Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOn();
    }
}
