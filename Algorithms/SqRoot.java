import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SqRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numb = scan.nextInt();

        float temp = 0;
        float sqroot = numb / 2;

        while (temp != sqroot) {

            temp = sqroot;
            sqroot = (numb / temp + temp) / 2;

        }
        Integer.parseInt("45");

        System.out.println(sqroot);
        scan.close();
    }
}