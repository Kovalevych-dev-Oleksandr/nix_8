package ua.com.alevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModuleMainTwo {
    public static void main(String[] args) {
    ModuleMainTwo mainTwo=new ModuleMainTwo();
    mainTwo.readResources();
    }

    public void readResources() {
        File file = new File(
                getClass().getClassLoader().getResource("text.txt").getFile()
        );

        try {
            Scanner sc =  new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

