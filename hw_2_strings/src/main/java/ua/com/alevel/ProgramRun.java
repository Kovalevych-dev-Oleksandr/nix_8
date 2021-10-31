package ua.com.alevel;


import ua.com.alevel.base_reverse.BaseReverse;
import ua.com.alevel.flip_according_to_the_word_order.FlipAccordingToTheWordOrder;
import ua.com.alevel.reverse_of_the_specified_word_in_the_line.ReverseOfTheSpecifiedWordInTheLine;
import ua.com.alevel.reverse_specified_letter.ReverseSpecifiedLetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.lang.System.*;


public class ProgramRun {
    public static void run() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        print();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                final EventProcessor eventProcessor = ProgramRun.getEvent(event);
                if (eventProcessor != null) {
                    eventProcessor.process(reader, out);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private static EventProcessor getEvent(final String event) {
        if ("1".equals(event)) {
            return new BaseReverse();

        }

        if ("2".equals(event)) {
            return new FlipAccordingToTheWordOrder();
        }
        if ("3".equals(event)) {
            return new ReverseOfTheSpecifiedWordInTheLine();
        }
        if ("4".equals(event)) {
            return new ReverseSpecifiedLetter();
        }

        if ("5".equals(event)) {
            exit(0);
        }
        return null;
    }

    public static void print() {
        out.println("If you need the first task, choose 1");
        for (final String s : Arrays.asList("If you need a second task, choose 2 ", "If you need a third task, choose 3 ", "If you want to finish, select 4", "Select you event: ")) {
            out.println(s);
        }
    }

}
