package com.e16.training.commandfunc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


public class CommandFactoryTest {
    private CommandFactory commandFactory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static String testCommandName = "testCommandName";
    private final static String testOutput = "output of test execution";
    private final static String otherTestCommandName = "otherTestCommandName";
    private final static String otherTestOutput = "output of other test execution";


    @Before
    public void initTestEnvironment() throws Exception {
        commandFactory = CommandFactory.init();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void destroyTestEnvironment() throws Exception {
        commandFactory = null;
        System.setOut(null);
    }

    @Test
    public void whenAddCommandAndExecuteThenReceiveOutputOfCommand() throws Exception {
        commandFactory.addCommand(testCommandName, () -> System.out.print(testOutput));
        commandFactory.executeCommand(testCommandName);

        assertThat(outContent.toString(), is(testOutput));
    }

    @Test
    public void whenCalledExecuteCommandNotExistThenOutputIsEmpty() throws Exception {
        commandFactory.executeCommand(testCommandName);

        assertThat(outContent.toString(), is(""));
    }

    @Test
    public void whenCallListCommandsThenOutputListOfCommands() throws Exception {
        commandFactory.addCommand(testCommandName, () -> System.out.print(testOutput));
        commandFactory.addCommand(otherTestCommandName, () -> System.out.print(otherTestOutput));
        commandFactory.listCommands();

        assertThat(outContent.toString(), containsString(testCommandName));
        assertThat(outContent.toString(), containsString(otherTestCommandName));
    }

    @Test
    public void whenCallExecuteCommandsThenReceiveOutputOfCommands() throws Exception {
        commandFactory.addCommand(testCommandName, () -> System.out.print(testOutput));
        commandFactory.addCommand(otherTestCommandName, () -> System.out.print(otherTestOutput));
        commandFactory.executeCommands(Arrays.asList(testCommandName, otherTestCommandName));

        assertThat(outContent.toString(), containsString(testOutput));
        assertThat(outContent.toString(), containsString(otherTestOutput));
    }

}