package com.e16.training.composite;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IndivisibleComponentTest {
    @Test
    public void operationIndivisibleComponent() throws Exception {
        assertThat(new IndivisibleComponent().operation(),
                is("IndivisibleComponent operation"));
    }

}