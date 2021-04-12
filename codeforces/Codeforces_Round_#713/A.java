import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int testcase = 0; testcase < t; testcase++) {
            int n = scan.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();

            System.out.println(spy(arr));
        }
        scan.close();
    }

    private static int spy(int[] arr) {

        int same = 0;
        if (arr[0] == arr[1])
            same = arr[0];
        else if (arr[0] == arr[2])
            same = arr[0];
        else
            same = arr[1]; // arr[0] is culprit

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != same)
                return i + 1;
        }
        return 0;
    }
}