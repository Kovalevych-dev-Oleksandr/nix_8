package ua.com.alevel.theareaoftriangle;

public class TriangleAreaCalculator {

    private TriangleAreaCalculator() {
    }

    public static double calculateArea(Coordinate a, Coordinate b, Coordinate c) {
        double x1 = a.getX();
        double x2 = b.getX();
        double x3 = c.getX();
        double y1 = a.getY();
        double y2 = b.getY();
        double y3 = c.getY();

        double sideA = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double sideB = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double sideC = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            return 0;
        }

        double p = (sideA + sideB + sideC) / 2.0;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
