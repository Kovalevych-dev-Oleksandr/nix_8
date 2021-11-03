package ua.com.alevel.horsemove;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class HorseMove implements EventProcessor {
    final static int SIZE_ROLS_AND_COLS = 8;

    @Override
    public void process(Reader reader, PrintStream writer) {


        Scanner str = new Scanner(System.in);
        writer.println("Select a starting position");
        writer.println("Enter a Cols:");
        int userStartPositionInRols = str.nextInt();
        writer.println("Enter a Rows:");
        int userStartPositionInCols = str.nextInt();
        printChess(userStartPositionInCols, userStartPositionInRols);

        writer.println("Select a Next position");
        writer.println("Enter a Cols:");
        int userNextPositionInRols = str.nextInt();
        writer.println("Enter a Rows:");
        int userNextPositionInCols = str.nextInt();


        if (checkingTheHorseCourse(userStartPositionInCols, userNextPositionInCols, userStartPositionInRols, userNextPositionInRols) == true) {

            writer.println("Step is possible");
            printChess(userNextPositionInCols, userNextPositionInRols);

        } else {
            writer.println("Step is not possible");
            return;
        }


    }


    public static void printChess(int userNextPositionInCols, int userNextPositionInRols) {
        for (int i = 0; i < SIZE_ROLS_AND_COLS+1; i++) {
            for (int j = 0; j < SIZE_ROLS_AND_COLS+1; j++) {
                if (i==0 && j==0 ){
                    System.out.print(" ");
                }else if (i == 0) {
                    System.out.print(" " +(j) + " ");
                } else if (j == 0) {
                    System.out.print(i);
                } else if (i == userNextPositionInCols && j == userNextPositionInRols ) {
                    System.out.print("!2!");

                } else {
                    System.out.print(" * ");
                }


            }
            System.out.println();
        }
    }

    public static boolean checkingTheHorseCourse(int userStartPositionInCols, int userNextPositionInCols, int userStartPositionInRols, int userNextPositionInRols) {
        int CheckingTheDifferenceCols = userNextPositionInCols - userStartPositionInCols  ;
        int CheckingTheDifferenceRols = userNextPositionInRols -userStartPositionInRols  ;
        boolean result = true;
        if ((CheckingTheDifferenceCols == 1 && CheckingTheDifferenceRols == 2) || (CheckingTheDifferenceCols == 2 && CheckingTheDifferenceRols == 1)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
