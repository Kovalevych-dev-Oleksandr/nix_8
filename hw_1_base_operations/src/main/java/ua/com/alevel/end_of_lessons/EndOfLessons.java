package ua.com.alevel.end_of_lessons;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class EndOfLessons implements EventProcessor {
    public void process(Reader reader, PrintStream writer) {
        writer.println("Enter a character 1-10");
        Scanner integ = new Scanner(System.in);
        int a = integ.nextInt();
        a = a * 45 + (a / 2) * 5 + ((a + 1) / 2 - 1) * 15;
        writer.print(a / 60 + 9);
        writer.print(":");
        writer.print(a % 60);
        writer.println();
        writer.println("Select you event: ");
        ;
    }
}
