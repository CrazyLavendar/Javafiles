class fibonacciApproach {

    public double FibonacciDefault(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            return FibonacciDefault(n - 1) + FibonacciDefault(n - 2);
        }
    }

    public double FibonacciTopDownMemorization(int n, int[] table) {

        if (table[n] < 0) {
            return FibonacciTopDownMemorization(n - 1, table) + FibonacciTopDownMemorization(n - 2, table);
        } else {
            return table[n];
        }

    }

    public double FibonacciBottomUpTabulation(int n, int[] table) {
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

}