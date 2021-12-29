package ua.com.alevel.list_of_dates;

import java.io.IOException;
import java.util.List;

import static ua.com.alevel.utils.Utils.readFile;

public final class ListOfDates {
    private static final String FILE_NAME = "list_of_dates.txt";
    private static final int LENGTH_OF_THE_ENTRY_IN_THE_LINE = 13;
    private static final int SIZE_YEAR = 4;
    private static final int COUNT_MONTH = 12;


    public static void run() throws IOException {
        List<String> arrayList = (readFile(ListOfDates.FILE_NAME));
        String bufferLine;
        for (int i = 0; i < arrayList.size(); i++) {
            bufferLine = arrayList.get(i);
            if (ListOfDates.LENGTH_OF_THE_ENTRY_IN_THE_LINE > bufferLine.length()) {
                bufferLine = removeCharAt(bufferLine);
                bufferLine = stringTransformation(bufferLine);
                arrayList.set(i, bufferLine);
            }
        }
        System.out.println(arrayList);
    }

    private static String removeCharAt(String line) {
        String clearLine = "";

        for (int i = 1; i < line.length() - 1; i++) {
            clearLine += line.charAt(i);
        }

        return clearLine;
    }

    private static String stringTransformation(String line) {
        String result = "";
        try {
            String[] array;
            array = line.split("/");
            int elementOfArrayYear = 0;
            int elementOfArrayDay = 0;
            int elementOfArrayMonth = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() == SIZE_YEAR) {
                    elementOfArrayYear = i;
                }
                if (array[i].length() < SIZE_YEAR && Integer.parseInt(array[i]) <= COUNT_MONTH) {
                    elementOfArrayMonth = i;
                }

            }
            elementOfArrayDay = array.length - (elementOfArrayMonth + elementOfArrayYear);
            for (int i : new int[]{elementOfArrayYear, elementOfArrayMonth, elementOfArrayDay}) {
                result += array[i];
            }
            if (result.length() != 8) {
                result = "not true";
            }
        } catch (Exception exception) {
            result = line + "-> incorrect input format in this date. Example “2020/04/05” or{2020/04/0}or[2020/04/05] or '2020/04/05'";
        }
        return result;

    }
}
