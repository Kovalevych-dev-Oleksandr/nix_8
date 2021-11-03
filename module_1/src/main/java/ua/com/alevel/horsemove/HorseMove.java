package ua.com.alevel.horsemove;

import ua.com.alevel.EventProcessor;
import ua.com.alevel.uniquecharactersinthearray.UniqueCharactersInTheArray;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class HorseMove implements EventProcessor {
    static final int SIZE_ROLS_AND_COLS = 8;

    @Override
    public void process(Reader reader, PrintStream writer) {

        Scanner str = new Scanner(System.in);

        String userStartPositionInRows;
        String userStartPositionInCols;
        String userNextPositionInRows;
        String userNextPositionInCols;

        writer.println("The size of your chessboard is 8X8, columns and rows are numbered from 1 to 8, please enter positive numbers from one to eight");
        writer.println("Select a starting position");
        writer.println("Enter a Cols:");
        userStartPositionInRows = str.nextLine();
        writer.println("Enter a Rows:");
        userStartPositionInCols = str.nextLine();

        if (UniqueCharactersInTheArray.checkingTheString(userStartPositionInCols) == true && UniqueCharactersInTheArray.checkingTheString(userStartPositionInRows) == true) {
            printChess(Integer.parseInt(userStartPositionInCols), Integer.parseInt(userStartPositionInRows));
            writer.println("This is horse (!2!)");
        } else {
            writer.println("Next time enter a number from one to eight in a string ");
            printEnd();
            return;
        }

        writer.println("Select a Next position");
        writer.println("Enter a Cols:");
        userNextPositionInRows = str.nextLine();
        writer.println("Enter a Rows:");
        userNextPositionInCols = str.nextLine();

        if (UniqueCharactersInTheArray.checkingTheString(userNextPositionInCols) == false && UniqueCharactersInTheArray.checkingTheString(userNextPositionInRows) == false) {
            writer.println("Next time enter a number from one to eight in a string ");
            printEnd();
            return;
        } else {
            if (checkingTheHorseCourse(Integer.parseInt(userStartPositionInCols), Integer.parseInt(userNextPositionInCols), Integer.parseInt(userStartPositionInRows), Integer.parseInt(userNextPositionInRows)) == true) {

                writer.println("Step is possible");
                printChess(Integer.parseInt(userNextPositionInCols), Integer.parseInt(userNextPositionInRows));

            } else {
                writer.println("Step is not possible");
                printEnd();
                return;
            }
            printEnd();

        }
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
        result = (CheckingTheDifferenceCols == 1 && CheckingTheDifferenceRols == 2) || (CheckingTheDifferenceCols == 2 && CheckingTheDifferenceRols == 1);
        return result;
    }

    public static boolean TestuserString(String userLine) {

        final boolean result = UniqueCharactersInTheArray.checkingTheString(userLine) == true;

        return result;
    }

    public static void printEnd() {
        System.out.println();
        System.out.println("Select you event: ");
    }
}


