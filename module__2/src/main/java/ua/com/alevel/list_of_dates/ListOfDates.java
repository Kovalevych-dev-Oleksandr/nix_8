package ua.com.alevel.list_of_dates;

import java.io.IOException;
import java.util.List;

import static ua.com.alevel.utils.Utils.readFile;
import static ua.com.alevel.utils.Utils.writeInFile;

public final class ListOfDates {
    private static final String READ_FILE_NAME = "input_list_of_dates.txt";
    private static final String WRITE_FILE_NAME = "output_list_of_dates.txt";
    private static final int LENGTH_OF_THE_ENTRY_IN_THE_LINE = 1;
    private static final int SIZE_YEAR = 4;
    private static final int COUNT_MONTH = 12;
    private static final int DAY_IN_MONTH = 31;


    public static List<String> run() throws IOException {
        List<String> arrayList = (readFile(ListOfDates.READ_FILE_NAME));
        String bufferLine;
        for (int i = 0; i < arrayList.size(); i++) {
            bufferLine = arrayList.get(i);
            if (bufferLine.isBlank() && ListOfDates.LENGTH_OF_THE_ENTRY_IN_THE_LINE < bufferLine.length()) {
                arrayList.remove(i);
                continue;
            } else {
                bufferLine = stringTransformation(bufferLine);
                arrayList.set(i, bufferLine);
            }

        }
        writeInFile(WRITE_FILE_NAME, arrayList);
        return arrayList;

    }

    private static String removeCharAt(String line) {
        StringBuilder clearLine = new StringBuilder();
        clearLine.append(line);
        System.out.println(line);
        clearLine.deleteCharAt(0);
        clearLine.deleteCharAt(clearLine.length() - 1);
        return clearLine.toString();
    }

    private static String stringTransformation(String line) {
        StringBuilder result = new StringBuilder();
        String userExceptionsOne = "-> Incorrect input format in this date. Example type “2020/04/05”or{2020/04/0}or|2020/04/05| or{2020/04/0}or[2020/04/05] or '2020/04/05'";
        String userExceptionsTwo = "->  Day or month more possible values";
        try {
            String[] array;
            array = removeCharAt(line).split("/");
            int elementOfArrayYear = 0;
            int elementOfArrayMonth = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() == SIZE_YEAR) {
                    elementOfArrayYear = i;
                }
                if (ListOfDates.SIZE_YEAR > array[i].length() && ListOfDates.COUNT_MONTH >= Integer.parseInt(array[i])) {
                    elementOfArrayMonth = i;
                }

            }
            int elementOfArrayDay = array.length - (elementOfArrayMonth + elementOfArrayYear);
            if (ListOfDates.DAY_IN_MONTH >= Integer.parseInt(array[elementOfArrayDay]) && COUNT_MONTH >= Integer.parseInt(array[elementOfArrayMonth])) {
                for (int i : new int[]{elementOfArrayYear, elementOfArrayMonth, elementOfArrayDay}) {
                    result.append(array[i]);
                }
            } else if (result.toString().matches("(?i).*[a-zа-я].*") || result.toString().matches("[a-zA-Zа-яА-Я]+")) {
                resultUserException(line, result, userExceptionsOne);

            } else {
                resultUserException(line, result, userExceptionsTwo);
            }

        } catch (Exception exception) {
            resultUserException(line, result, userExceptionsOne);
        }
        return result.toString();

    }

    private static void resultUserException(String line, StringBuilder result, String userExceptions) {
        result.delete(0, result.length());
        result.append(line);
        result.append(userExceptions);
    }
}
