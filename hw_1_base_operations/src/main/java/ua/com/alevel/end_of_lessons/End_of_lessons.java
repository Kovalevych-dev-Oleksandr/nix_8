package ua.com.alevel.end_of_lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class End_of_lessons {

    public void run (BufferedReader reader) throws IOException
    {
        System.out.println("Enter a character 1-10");
        Scanner integ = new Scanner(System.in);
        int a = integ.nextInt();
        a = a * 45 + (a / 2) * 5 + ((a + 1) / 2 - 1) * 15;
        System.out.print(a / 60 + 9);
        System.out.print(":");
        System.out.print(a % 60);
        System.out.println();
        System.out.println("Select you event: ");;
    }
}
