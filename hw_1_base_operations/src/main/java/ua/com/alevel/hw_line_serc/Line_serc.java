package ua.com.alevel.hw_line_serc;

import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Line_serc
{
    public void run (BufferedReader reader) throws IOException
    {
        Scanner con = new Scanner(System.in);

        String s = con.nextLine();

        s = s.replaceAll("[1234567890]","");

        System.out.println(s);

        con.close();
        String str = s;
        int len = str.length();
        Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, 26));

        for (int i = 0; i < len; ++i)
        {
            char charAt = str.charAt(i);

            if (!numChars.containsKey(charAt))
            {
                numChars.put(charAt, 1);
            }
            else
            {
                numChars.put(charAt, numChars.get(charAt) + 1);
            }

        }System.out.println(numChars);

        System.out.println();
    }
}



