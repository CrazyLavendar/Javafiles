public class unboundedKnapsac {
    public int cutRod(int price[], int n) {

        // Recursion - Exponential
        /*
         * if(n<= 0) return 0; int max =0; for(int i =0 ; i< n ; i++) // 0 to n-2 means
         * 1 cut , n-1 means take full piece max = Math.max(max , price[i] +
         * cutRod(price , n-i-1)); return max;
         */

        // Using DP
        int[] val = new int[n + 1];
        val[0] = 0; // no cut;

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + val[i - j - 1]);
            }
            val[i] = max;
        }
        return val[n];
    }
}
