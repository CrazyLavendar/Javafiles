
import java.util.ArrayList;
import java.util.Scanner;

class ASEendExam {
    public static void main(String[] args) {

        System.out.println(
                "Puse 1 : Does not meet the required conditions \n Puse 2: Testcase cannot form a triangle\n Puse 3: Right-angled Isoceles Triangle \n Puse 4: Ordinary Right Triangle \n Puse 5: Ordinary Triangle \n Puse 6: Equailateral Triangle \n Puse 7 Ordinary Isoceles ");
        for (int executing = 1; executing <= 1; executing++) {

            DataFlowDiagImplement();
        }

    }

    public static void DataFlowDiagImplement() {

        ArrayList<Integer> nodes = new ArrayList<Integer>();
        float z = 0;
        float x = 0;
        float y = 0;

        for (int i = 1; i <= 1; i++) {
            Scanner scan = new Scanner(System.in);
            nodes.clear();
            nodes.add(1);
            nodes.add(2);

            if (scan.hasNext())
                x = scan.nextFloat();
            nodes.add(3);

            if (scan.hasNext())
                y = scan.nextFloat();
            nodes.add(4);

            if (scan.hasNext())
                z = scan.nextFloat();
            if (x < 1 || y < 1 || z < 1) {
                nodes.add(5);
                System.out.print("DU-Path followed " + nodes);
                System.out.println("\tDoes not meet the required conditions");
                scan.close();
                // return;
                continue;
            }
            if (!checkValidity(x, y, z)) {
                nodes.add(6);
                System.out.print("DU-Path followed " + nodes);
                System.out.println("\tEntered inputs from Testcase cannot form a triangle");
                scan.close();
                // return;
                continue;
            }
            // Check for right triangle
            if (isRight(x, y, z) && nodes.add(7)) {
                if (x == y || y == z || z == x && nodes.add(8)) {
                    nodes.add(9);
                    System.out.print("DU-Path followed " + nodes);
                    System.out.println("\tTriangle type : Right-angled Isoceles Triangle");
                    scan.close();
                    // return;
                    continue;
                } else {
                    nodes.add(10);
                    System.out.print("DU-Path followed " + nodes);
                    System.out.println("\tTriangle type : Ordinary Right-angled Triangle");
                    scan.close();
                    // return;
                    continue;
                }
            }
            // Check for isoceles triangle
            if (x == y || y == z || z == x && nodes.add(11))

            {
                if (x == y && y == z && nodes.add(13)) {
                    // Check for equilateral triangle
                    nodes.add(14);
                    System.out.print("DU-Path followed " + nodes);
                    System.out.println("\tTriangle type : Equilateral Triangle");
                    scan.close();
                    // return;
                    continue;
                } else {
                    nodes.add(15);
                    System.out.print("DU-Path followed " + nodes);
                    System.out.println("\tTriangle type : Ordinary Isoceles Triangle");
                    scan.close();
                    // return;
                    continue;
                }
            } else {
                nodes.add(12);
                System.out.print("DU-Path followed " + nodes);
                System.out.println("\tTriangle type : Ordinary Triangle(Scalene)");
                scan.close();
                // return;

            }
        }
        // scan.close();
        return;

    }

    public static boolean checkValidity(float a, float b, float c) {
        // check condition
        if (a + b <= c || a + c <= b || b + c <= a)
            return false;
        else
            return true;
    }

    static void checkTriangle(float x, float y, float z) {

    }

    static boolean isRight(float side1, float side2, float side3) {

        int a = (int) ((Math.pow(side1, 2) + Math.pow(side2, 2)));
        int b = (int) Math.floor((Math.pow(side3, 2)));
        // System.out.println(a + " " + b);
        if (a == b) {
            return true;
        }
        a = (int) ((Math.pow(side2, 2) + Math.pow(side3, 2)));
        b = (int) (Math.pow(side1, 2));
        // System.out.println(a + " " + b);
        if (a == b) {
            return true;
        }
        a = (int) ((Math.pow(side1, 2) + Math.pow(side3, 2)));
        b = (int) (Math.pow(side2, 2));
        // System.out.println(a + " " + b);
        if (a == b) {
            return true;
        }
        return false;
    }

}