package com.e16.training.command;

public class FlipDownCommand implements Command {
    private Light theLight;

    public FlipDownCommand(final Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOff();
    }
}
