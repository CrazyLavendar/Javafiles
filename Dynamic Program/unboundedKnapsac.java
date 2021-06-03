public class unboundedKnapsac {

    private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {

        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }

    public int cutRod(int price[], int n) {

        // Recursion - Exponential
        /*
         * if(n<= 0) return 0; int max =0;
         for(int i =0 ; i< n ; i++) 
         // 0 to n-2 means1 cut , n-1 means take full piece 
         max = Math.max(max , price[i] + cutRod(price , n-i-1)); return max;
         */

        // Using DP
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) { // rod sizes
            for (int j = 0; j <= n; j++) {
                if (i > j)
                    dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
            }
        }
        return dp[n];
    }
}
