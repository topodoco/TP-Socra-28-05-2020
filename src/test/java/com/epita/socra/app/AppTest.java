package com.epita.socra.app;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Simple test of one int
     */
    @Test
    public void SimpleTest() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("2945").thenReturn("stop");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, write here your arabic number: (Say stop to stop)");
        verify(mock).write(argThat(message -> message.contains("MMCMXLV")));
    }

    /**
     * multiple inputs test
     */
    @Test
    public void MultipleInputs() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("2945").thenReturn("120").thenReturn("stop");
        App app = new App(mock);
        app.run();

        verify(mock).write(argThat(message -> message.contains("MMCMXLV")));
        verify(mock).write(argThat(message -> message.contains("CXX")));
    }


    /**
     * negative test
     */
    @Test
    public void NegativeTest() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("-23").thenReturn("stop");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, write here your arabic number: (Say stop to stop)");
        verify(mock).write(argThat(message -> message.contains("Negative integers not handled")));
    }


    /**
     * out of bound test
     */
    @Test
    public void TooBigOutput() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("3244224").thenReturn("stop");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, write here your arabic number: (Say stop to stop)");
        verify(mock).write(argThat(message -> message.contains("Your number is too big (>3000)")));
    }
}
