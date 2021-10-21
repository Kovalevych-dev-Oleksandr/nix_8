package ua.com.alevel;

import ua.com.alevel.end_of_lessons.EndOfLessons;
import ua.com.alevel.hw_line_1.LineOne;
import ua.com.alevel.hw_line_serc.EventProcessor;
import ua.com.alevel.hw_line_serc.LineTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgramRun {
    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                EventProcessor eventProcessor = getEvent(event);
                if (eventProcessor != null) {
                    eventProcessor.process(reader, System.out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EventProcessor getEvent(String event) {
        if ("1".equals(event)) {
            return new LineOne();

        }

        if ("2".equals(event)) {
            return new LineTwo();
        }
        if ("3".equals(event)) {
            return new EndOfLessons();
        }

        if ("4".equals(event)) {
            System.exit(0);
        }
        return null;
    }

    public static void print() {
        System.out.println(" If you need the first task, choose 1");
        System.out.println(" If you need a second task, choose 2 ");
        System.out.println("If you need a third task, choose 3 ");
        System.out.println(" If you want to finish, select 0");
        System.out.println("Select you event: ");
        System.out.println();
    }

}
