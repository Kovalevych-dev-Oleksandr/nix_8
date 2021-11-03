package ua.com.alevel;

import ua.com.alevel.horsemove.HorseMove;
import ua.com.alevel.uniquecharactersinthearray.UniqueCharactersInTheArray;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class TheAreaOfTheTriangle implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {

        Scanner str = new Scanner(System.in);
        String sideNumberA;
        String sideNumberB;
        String sideNumberC;
        int integerSideNumberA;
        int integerSideNumberB;
        int integerSideNumberC;
        writer.println("It is necessary to enter numbers without symbols and spaces");
        writer.println("Enter the a positive integer side A");
        sideNumberA = str.nextLine();
        writer.println("Enter the a positive integer side B");
        sideNumberC = str.nextLine();
        writer.println("Enter the a positive integer side C");
        sideNumberB = str.nextLine();

        if (UniqueCharactersInTheArray.checkingTheString(sideNumberA) == true && UniqueCharactersInTheArray.checkingTheString(sideNumberB) == true && UniqueCharactersInTheArray.checkingTheString(sideNumberC) == true) {
            integerSideNumberA = UniqueCharactersInTheArray.stringToInt(sideNumberA);
            integerSideNumberB = UniqueCharactersInTheArray.stringToInt(sideNumberB);
            integerSideNumberC = UniqueCharactersInTheArray.stringToInt(sideNumberC);
            if(checTheTriangle(integerSideNumberA,integerSideNumberB,integerSideNumberC)==true){
                writer.println("Result is: " + areaTriangle(integerSideNumberA, integerSideNumberB, integerSideNumberC) + "(M^2)");
            }else{
                writer.println("There is no such triangle, since the sum of its two sides is less than or equal to the third");
                HorseMove.printEnd();
                return;
            }
        } else {
            writer.println("Next time enter a integer number without symbols and spaces");
            HorseMove.printEnd();

            return;
        }
        HorseMove.printEnd();

    }


    public static double areaTriangle(int sideA, int sideB, int sideC) {
        int perimeter = (sideA + sideB + sideC);
        double area = Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
        return area;
    }

    public static boolean checTheTriangle(int sideA, int sideB, int sideC) {
        boolean result =false;
        if (sideA + sideB >= sideC || sideA + sideC >= sideB || sideC + sideB >= sideA) {
        result =true;
        }
       return result;
    }
}
