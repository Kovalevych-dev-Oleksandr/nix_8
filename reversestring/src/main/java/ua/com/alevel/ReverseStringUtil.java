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
        return reverseUsersString;
    }

    public static String reverseWordString(String usersString) {
        String reverseUsersString = "";
        String[] array = usersString.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            reverseUsersString = reverseUsersString + reverseString(array[i] + ' ');

        }
        return reverseUsersString;

    }


}
