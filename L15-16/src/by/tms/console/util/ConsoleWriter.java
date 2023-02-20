package by.tms.console.util;

import by.tms.util.Writer;

public class ConsoleWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }
}
