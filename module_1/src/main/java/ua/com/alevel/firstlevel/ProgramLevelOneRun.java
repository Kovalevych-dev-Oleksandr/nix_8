package ua.com.alevel.firstlevel;

import ua.com.alevel.EventProcessor;
import ua.com.alevel.TheAreaOfTheTriangle;
import ua.com.alevel.horsemove.HorseMove;
import ua.com.alevel.uniquecharactersinthearray.UniqueCharactersInTheArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.lang.System.*;

public class ProgramLevelOneRun {

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        ProgramLevelOneRun.print();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                EventProcessor eventProcessor = getEvent(event);
                if (eventProcessor != null) {
                    eventProcessor.process(reader, out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EventProcessor getEvent(String event) {
        if ("1".equals(event)) {
            return new UniqueCharactersInTheArray();
        }

        if ("2".equals(event)) {
            return new HorseMove();
        }
        if ("3".equals(event)) {
            return new TheAreaOfTheTriangle();
        }
        if ("4".equals(event)) {
            // return new ReverseSpecifiedLetter();
        }

        if ("5".equals(event)) {
            exit(0);
        }
        return null;
    }

    private static void print() {
        out.println("If you need Unique Characters In The Array, choose 1");
        for (String s : Arrays.asList("If you need task Horse move, choose 2 ", "If you need  The Area Of The Triangle, choose 3 ", "If you need areverse of letters in a lineselect 4 ", "If you want to finish, select 5", "Select you event: ")) {
            out.println(s);
        }
    }
}
