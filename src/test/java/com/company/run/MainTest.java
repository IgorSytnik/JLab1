package com.company.run;

import com.company.run.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {

    @Test
    void mainTest() {
        String input = "";
        String[] args = null;
        final InputStream original = System.in;
        final ByteArrayInputStream bin = new ByteArrayInputStream(input.getBytes());
        System.setIn(bin);
        Main.main(args);
        System.setIn(original);
    }
}