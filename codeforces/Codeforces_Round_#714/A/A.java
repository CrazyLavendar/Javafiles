import java.util.Scanner;

public class A {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcase = scan.nextInt();
        for (int t = 0; t < testcase; t++) {
            int n = scan.nextInt(), k = scan.nextInt();
            solve(n, k);
        }
        scan.close();
    }

    private static void solve(int n, int k) {
        if (2 * k >= n) {
            System.out.println(-1);
            return;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        int i = 1;
        for (int j = 0; j < k; j++, i += 2) {
            arr[i] = i + 2;
            arr[i + 1] = i + 1;
        }
        while (i < n) {
            arr[i] = i + 1;
            i++;
        }
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return;
    }
}