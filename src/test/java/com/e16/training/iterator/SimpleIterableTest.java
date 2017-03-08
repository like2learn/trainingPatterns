package com.e16.training.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleIterableTest {
    private final String[] strings = new String[] {"A", "B", "C", "D"};
    private final SimpleIterable<String> stringSimpleIterable =
            new SimpleIterable<>(strings);


    @Test
    public void whenCallNextReturnNextItem() throws Exception {
        Iterator<String> iter = stringSimpleIterable.getIterator();

        for (int i = 0; i < stringSimpleIterable.size(); i++) {
            assertThat(iter.next(), is(strings[i]));
        }
    }

    @Test
    public void whenCallSizeReturnSizeOfArray() throws Exception {
        assertThat(stringSimpleIterable.size(), is(strings.length));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoMoreElementsThrowException() {
        Iterator<String> iter = stringSimpleIterable.getIterator();

        for (int i = 0; i < strings.length; i++) {
            iter.next();
        }

        /* Already has no elements */
        iter.next();
    }
}