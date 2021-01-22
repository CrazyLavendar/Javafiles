class recurbasic {
    public static void main(String[] args) {
        System.out.println(FibonacciTail(5, 0, 1));
    }

    static int FibonacciHead(int N) {

        if (N <= 0) {

            return 0;
        }
        if (N == 1) {

            return 1;
        }

        else {
            return FibonacciHead(N - 1) + FibonacciHead(N - 2);

        }
    }

    static int FibonacciTail(int N, int a, int b) {

        if (N == 0) {

            return a;
        }
        if (N == 1) {

            return b;
        }

        return FibonacciTail(N - 1, b, a + b);

    }

    static int FactorialByTail(int N, int result) { // Factorila in Tail recursion
        if (N == 1)
            return result;

        return FactorialByTail(N - 1, N * result);
    }

    static void head(int n) {

        System.out.println("Called the funcion " + n);
        if (n == 0)
            return;

        head(n - 1);
        System.out.println("The value of n = " + n);
    }

    static void tail(int n) {
        System.out.println("Called the funcion " + n);
        if (n == 0)
            return;

        System.out.println("The value of n = " + n);
        tail(n - 1);

    }
}