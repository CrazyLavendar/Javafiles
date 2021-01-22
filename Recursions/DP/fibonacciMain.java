import java.util.Scanner;

public class fibonacciMain {
    public static void main(String[] args) {
        fibonacciApproach approach = new fibonacciApproach();
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();
        int[] array = new int[x + 1];

        for (int i = 0; i < array.length; i++)
            array[i] = -1;
        array[0] = 0;
        array[1] = 1;
        System.out.println(approach.FibonacciBottomUpTabulation(x, array));
        for (int i = 0; i < array.length; i++)
            array[i] = -1;
        array[0] = 0;
        array[1] = 1;

        System.out.println(approach.FibonacciTopDownMemorization(x, array));
        System.out.println(approach.FibonacciDefault(x));

    }
}
