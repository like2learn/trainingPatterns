package com.e16.training.composite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CompositeComponentTest {
    private CompositeComponent compositeComponent;
    private IndivisibleComponent indivisibleComponent;

    @Before
    public void setUp() throws Exception {
        compositeComponent = new CompositeComponent();
        indivisibleComponent = new IndivisibleComponent();
    }

    @After
    public void tearDown() throws Exception {
        compositeComponent = null;
        indivisibleComponent = null;
    }

    @Test
    public void operationCompositeComponent() throws Exception {
        assertThat(compositeComponent.operation(),
                is("CompositeComponent operation"));
    }

    @Test
    public void whenAddThenTrueAndReturnAdded() throws Exception {
        assertThat(compositeComponent.add(indivisibleComponent), is(true));
        assertThat(compositeComponent.getComponent(0), is(indivisibleComponent));
    }

    @Test
    public void whenRemoveAndNotFoundThenFalse() throws Exception {
        assertThat(compositeComponent.remove(indivisibleComponent), is(false));
    }

    @Test
    public void whenRemoveAndRemovedThenTrue() throws Exception {
        compositeComponent.add(indivisibleComponent);

        assertThat(compositeComponent.remove(indivisibleComponent), is(true));
    }

}