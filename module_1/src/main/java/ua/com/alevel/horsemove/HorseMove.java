package ua.com.alevel.horsemove;

import ua.com.alevel.EventProcessor;
import ua.com.alevel.uniquecharactersinthearray.UniqueCharactersInTheArray;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class HorseMove implements EventProcessor {
    final static int SIZE_ROLS_AND_COLS = 8;

    @Override
    public void process(Reader reader, PrintStream writer) {


        Scanner str = new Scanner(System.in);

        int userStartPositionInRows;
        int userStartPositionInCols;
        int userNextPositionInRows;
        int userNextPositionInCols;

        writer.println("Select a starting position");
        writer.println("Enter a Cols:");

        String userLine = str.nextLine();
        userStartPositionInRows = Integer.parseInt(userLine);

        writer.println("Enter a Rows:");

        userLine = str.nextLine();

        userStartPositionInCols = Integer.parseInt(userLine);
        printChess(userStartPositionInCols, userStartPositionInRows);

        writer.println("Select a Next position");
        writer.println("Enter a Cols:");
        userLine = str.nextLine();
        userNextPositionInRows = Integer.parseInt(userLine);
        writer.println("Enter a Rows:");
        userLine = str.nextLine();
        userNextPositionInCols = Integer.parseInt(userLine);




        if (checkingTheHorseCourse(userStartPositionInCols, userNextPositionInCols, userStartPositionInRows, userNextPositionInRows) == true) {

            writer.println("Step is possible");
            printChess(userNextPositionInCols, userNextPositionInRows);

        } else {
            writer.println("Step is not possible");
            writer.println();
            writer.println("Select you event: ");
            return;
        }
        writer.println();
        writer.println("Select you event: ");

    }


    public static void printChess(int userNextPositionInCols, int userNextPositionInRols) {
        for (int i = 0; i < SIZE_ROLS_AND_COLS + 1; i++) {
            for (int j = 0; j < SIZE_ROLS_AND_COLS + 1; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" ");
                } else if (i == 0) {
                    System.out.print(" " + (j) + " ");
                } else if (j == 0) {
                    System.out.print(i);
                } else if (i == userNextPositionInCols && j == userNextPositionInRols) {
                    System.out.print("!2!");

                } else {
                    System.out.print(" * ");
                }


            }
            System.out.println();
        }
    }

    public static boolean checkingTheHorseCourse(int userStartPositionInCols, int userNextPositionInCols, int userStartPositionInRols, int userNextPositionInRols) {
        int CheckingTheDifferenceCols = userNextPositionInCols - userStartPositionInCols;
        int CheckingTheDifferenceRols = userNextPositionInRols - userStartPositionInRols;
        boolean result = true;
        if ((CheckingTheDifferenceCols == 1 && CheckingTheDifferenceRols == 2) || (CheckingTheDifferenceCols == 2 && CheckingTheDifferenceRols == 1)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /*public static boolean userStringToInt(String userLine) {

        boolean result=;
        if (UniqueCharactersInTheArray.checkingTheString(userLine) == true) {

        }
           // System.out.println("Next time enter a number positive number(1-8) in a string without spaces and characters");


        return ;
    }*/


    // Integer.parseInt(userLine);

}


