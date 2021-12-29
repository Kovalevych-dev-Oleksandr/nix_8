package ua.com.alevel.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readFile(String fileName) throws IOException {
        List<String> arrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line=reader.readLine())!=null) {
            arrayList.add(line);
        }
        reader.close();
        return arrayList;
    }


    public static String writeInFile(String fileName, List<String> arrayList) {
        try {
            FileWriter writer = new FileWriter(fileName, false);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.write(arrayList.get(i));
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "file not write";
        }
        return "file write";
    }
}
