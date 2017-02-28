package com.e16.training.commandfunc;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class CommandFactory {
    private final HashMap<String, Command> commands;

    public final static String COMMANDS_OUTPUT_DELIMITER = ", ";
    public final static String COMMANDS_OUTPUT_INTRO = "Enabled commands: ";

    private CommandFactory() {
        commands = new HashMap<String, Command>();
    }

    public void addCommand(final String commandName, final Command command) {
        commands.put(commandName, command);
    }

    public void executeCommand(final String commandName) {
        if (commands.containsKey(commandName)) {
            commands.get(commandName).apply();
        }
    }

    public void listCommands() {
        System.out.println(COMMANDS_OUTPUT_INTRO + commands.keySet().stream()
                .collect(Collectors.joining(COMMANDS_OUTPUT_DELIMITER)));
    }

    public void executeCommands(final List<String> commandNamesList) {
        commandNamesList.forEach(this::executeCommand);
    }

    public static CommandFactory init() {
        final CommandFactory commandFactory = new CommandFactory();
        return commandFactory;
    }
}
