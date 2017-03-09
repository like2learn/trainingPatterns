package com.e16.training.builder;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LetterTest {
    private static final String FROM = "my@mail.com";
    private static final String TO = "you@mail.com";
    private static final String MESSAGE = "test message";
    private static final String SUBJECT = "test subject";
    private static final Letter letter =
            new Letter.Builder(FROM, TO)
                    .withMessage(MESSAGE)
                    .withSubject(SUBJECT)
                    .build();

    @Test(expected = IllegalStateException.class)
    public void whenHasNoFromThenThrowException() {
        new Letter.Builder(null, TO).build();
    }

    @Test(expected = IllegalStateException.class)
    public void whenHasNoToThenThrowException() {
        new Letter.Builder(FROM, null).build();
    }

    @Test
    public void whenCallFromThenReturnFrom() {
        assertThat(letter.getFrom(), is(FROM));
    }

    @Test
    public void whenCallToThenReturnTo() {
        assertThat(letter.getTo(), is(TO));
    }

    @Test
    public void whenCallMessageThenReturnMessage() {
        assertThat(letter.getMessage(), is(MESSAGE));
    }

    @Test
    public void whenCallSubjectThenReturnSubject() {
        assertThat(letter.getSubject(), is(SUBJECT));
    }
}