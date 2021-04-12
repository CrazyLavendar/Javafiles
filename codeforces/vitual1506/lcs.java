import java.util.Scanner;

public class lcs {
    public static void main(String[] args) {
        // System.out.println(lcs("OldSite:GeeksforGeeks.org",
        // "NewSite:GeeksQuiz.com"));
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < testcase; i++) {
            String a = scan.nextLine(), b = scan.nextLine();
            int max = lcs(a, b);
            // System.out.println(max);
            System.out.println(a.length() + b.length() - 2 * max);
        }
        scan.close();

    }

    static int lcs(String a, String b) {

        int m = a.length(), n = b.length();
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == b.charAt(j) && (i == 0 || j == 0)) {
                    dp[i][j] = 1;
                } else if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (max < dp[i][j])
                    max = dp[i][j];
            }

        }

        return max;
    }
}
