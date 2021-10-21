package ua.com.alevel.hw_line_serc;

import java.io.PrintStream;
import java.io.Reader;

public interface EventProcessor {
    void process(Reader reader, PrintStream writer);

}
