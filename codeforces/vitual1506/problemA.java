import java.util.*;
import java.io.*;

public class problemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();

        int n, m;
        long find;
        for (int i = 0; i < testcase; i++) {

            n = scan.nextInt();
            m = scan.nextInt();
            find = scan.nextLong();
            System.out.println(solve(n, m, find));
        }

        scan.close();

    }

    public static long solve(int row, int col, long find) {
        long i = 0, j = 0;
        // long curr = 0;
        j = (find / row) + 1;
        // curr = curr - row;
        // i--;
        i = find % row;

        // System.out.println(i + " " + j);
        if (i == 0)
            return (j - 1) * col;
        else
            return ((i - 1) * col + j);

    }
}