package ua.com.alevel.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readFile(String fileName) throws IOException {
        List<String> arrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while (null != (line = reader.readLine())) {
            arrayList.add(line);
        }
        reader.close();


        return arrayList;
    }
}
