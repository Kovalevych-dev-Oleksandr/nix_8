package ua.com.alevel;
import ua.com.alevel.end_of_lessons.End_of_lessons;
import ua.com.alevel.hw_line_1.Line_1;
import ua.com.alevel.hw_line_serc.Line_serc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgramRun {
    public static void run()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" If you need the first task, choose 1");
        System.out.println(" If you need a second task, choose 2 ");
        System.out.println("If you need a third task, choose 3 ");
        System.out.println(" If you want to finish, select 0");
        System.out.println("Select you event: ");
        System.out.println();
        String event;
        try
        {
            while ((event = reader.readLine()) !=null) {
               System.out.println("Select you event: ");
                switch (event)
                {

                    case "1":
                    {
                        System.out.println("you have chosen a event: " + event);
                        new Line_1().run(reader);

                    } break;

                    case "2":
                    {
                        System.out.println("you have chosen a event: " + event);
                        new Line_serc().run(reader);
                    }break;
                    case "3":
                    {
                        System.out.println("you have chosen a event: " + event);
                        new End_of_lessons().run(reader);
                    }break;

                    case "0":
                    {
                        System.out.println("you have chosen a event: " + event);
                        System.exit(0);
                    }break;

                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }

}
