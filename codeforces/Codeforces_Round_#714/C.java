import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        for (int t = 0; t < testcase; t++) {
            int m = scan.nextInt(), n = scan.nextInt();
            solve(m, n);
        }
        scan.close();
    }

    private static void solve(int m, int n) {

        String temp = Integer.toString(m);
        StringBuilder curr = new StringBuilder(temp);
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res = new StringBuilder();
            for (int i = 0; i < curr.length(); i++) {
                int val = curr.charAt(i) - '0';
                val++;
                res.append(val);
                long x = ((Integer.valueOf(res.toString())) % 1000000007);
                res = new StringBuilder(String.valueOf(x));
            }

            curr = res;
            n--;
        }

        System.out.println(res.length() % 1000000007);

    }

    private static void solve2(int m, int n) {
        long[] store = new long[10];
        String temp = Integer.toString(m);

        for (int i = 0; i < temp.length(); i++) {
            store[temp.charAt(i) - '0']++;
        }

        while (n > 0) {
            long[] cache = new long[10];
            for (int i = 0; i < 10; i++) {
                if (i != 9) {
                    cache[i + 1] = store[i];
                } else {
                    cache[0] = store[i];
                    cache[1] += store[i];
                }
            }
            store = cache;
            n--;
        }

        long res = 0;
        for (long x : store)
            res += x;
        System.out.println(res % 1000000007);

    }
}
