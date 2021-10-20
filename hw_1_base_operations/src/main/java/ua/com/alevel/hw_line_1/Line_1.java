package ua.com.alevel.hw_line_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class Line_1
{
    public void run (BufferedReader reader) throws IOException
    {

        int sum = 0;
        Scanner str = new Scanner(System.in);
        System.out.println("Enter a character \n");
        String a = str.next();

        for(int i = 0; i < a.length(); i++) {
            if(Character.isDigit(a.charAt(i))) {
                sum = sum + Integer.parseInt(a.charAt(i) + "");
            }
        }

        System.out.println("sum is:"+sum);
        System.out.println();
        System.out.println("Select you event: ");

    }



}
