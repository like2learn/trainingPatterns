package com.e16.training.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class CommandTest {

    private final String lineSeparator = System.lineSeparator();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Light lightMock;

    @Test
    public void whenCallTurnOnThenOutputLightOn() {
        Light light = new Light();
        light.turnOn();

        assertThat(outContent.toString(), is("The light is on" + lineSeparator));
    }

    @Test
    public void whenCallTurnOnThenOutputLightOff() {
        Light light = new Light();
        light.turnOff();

        assertThat(outContent.toString(), is("The light is off" + lineSeparator));
    }

    @Test
    public void whenCallFlipUpLightShouldTurnOn() throws Exception {
        final FlipUpCommand flipUpCommand = new FlipUpCommand(lightMock);
        flipUpCommand.execute();

        verify(lightMock, times(1)).turnOn();
    }

    @Test
    public void whenCallFlipDownLightShouldTurnOff() throws Exception {
        final FlipDownCommand flipDownCommand = new FlipDownCommand(lightMock);
        flipDownCommand.execute();

        verify(lightMock, times(1)).turnOff();
    }

    @Test
    public void shouldCallLightTwiceOnThreeDown() {
        final Switch switch_ = new Switch();
        final Command flipUpCommand = new FlipUpCommand(lightMock);
        final Command flipDownCommand = new FlipDownCommand(lightMock);


        switch_.storeAndExecute(flipUpCommand);
        switch_.storeAndExecute(flipUpCommand);

        verify(lightMock, times(2)).turnOn();


        switch_.storeAndExecute(flipDownCommand);
        switch_.storeAndExecute(flipDownCommand);
        switch_.storeAndExecute(flipDownCommand);

        verify(lightMock, times(3)).turnOff();
    }

    @Before
    public void initTest() {
        System.setOut(new PrintStream(outContent));
        lightMock = Mockito.mock(Light.class);
    }

    @After
    public void destroyTest() {
        System.setOut(null);
        lightMock = null;
    }


}