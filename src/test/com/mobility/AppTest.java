package com.mobility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() throws IOException {
        System.setOut(null);
        outContent.close();
    }

    @Test
    public void validUpperCase() {
        new App(Collections.singletonList("Aa3v4#"));
        assertEquals("PASS\r\n", outContent.toString());
    }

    @Test
    public void notValid() {
        new App(Arrays.asList("aa3v4#", "Aav#", "Aav #", "Aa-"));
        assertEquals("FAIL\r\nFAIL\r\nFAIL\r\nFAIL\r\n", outContent.toString());
    }

}
