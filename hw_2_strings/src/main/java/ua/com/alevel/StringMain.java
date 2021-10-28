package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringMain {
    public static final String nameOne = "name1";
    public static final String nameTwo = "name2";

    public static void main(String[] args) {
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            int ran = random.nextInt(2);
            User user = new User();
            if (ran == 0) {
                user.setName(nameOne);
            } else {
                user.setName(nameTwo);
            }
            user.setAge(i);
            users.add(user);
        }
        long count = users.stream()
                .filter(user -> user.getName().equals(nameOne))
                .count();
        System.out.println("count = " + count);

    }
}
