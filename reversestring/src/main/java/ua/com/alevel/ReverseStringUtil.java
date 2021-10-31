package ua.com.alevel;

public final class ReverseStringUtil {

    private ReverseStringUtil() {
    }

    public static String reverseString(String usersString) {

        char[] array = usersString.toCharArray();
        String reverseUsersString = "";


        for (int i = array.length - 1; i >= 0; i--) {
            reverseUsersString = reverseUsersString + array[i];
        }
        return reverseUsersString + " ";
    }

    public static String reverseWordString(String usersString) {
        String reverseUsersString = "";
        String[] array = usersString.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            reverseUsersString = reverseUsersString + reverseString(array[i] + " ");
        }
        return reverseUsersString + " ";
    }

    public static String reverseSpecifiedWordInLine(String usersString, int indexArray) {
        String reverseUsersString = "";
        String[] array = usersString.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            if (i == indexArray) {
                reverseUsersString = reverseUsersString + reverseString(array[i]);
            } else {
                reverseUsersString = reverseUsersString + array[i] + " ";
            }
        }
        return reverseUsersString;
    }

    public static String reverseSpecifiedLetterInString(String usersString, int indexLetterArrayFirst, int indexLetterArrayLast) {
        String reverseUsersString = "";
        char[] array = usersString.toCharArray();
        for (int i=0;i<indexLetterArrayFirst;i++){
            reverseUsersString = reverseUsersString + array[i];
        }
        for (int i = indexLetterArrayLast; i >= indexLetterArrayFirst; i--) {
            reverseUsersString = reverseUsersString + array[i];
        }
        for(int i=indexLetterArrayLast;i<array.length;i++){
            reverseUsersString = reverseUsersString + array[i];
        }


        return reverseUsersString + " ";

    }

}
