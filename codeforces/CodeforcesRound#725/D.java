/*Jayam Vimal - java template*/

import java.io.*;
import java.util.*;

public class D {
    
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {

        int t = i();
        while (t-- > 0) {

            long a = i(), b = i(), k = i();
            
            if (a == b && k == 0) {
                out.println("YES");

            }
            else if (a==b && k != 0) {
                out.println("NO");
             
            }
            else if ((a % b == 0 || b % a == 0) && k == 1) {
                out.println("YES");

            }
        
            else {
                long gcd = gcd(a, b);
                int primeFactors = primeFactors((int) gcd);

                if (k >= 2 && k <= 2 * primeFactors) {
                    out.println("YES");
                }
                else
                    out.println("NO");
            }
        
        }

                out.flush();
    }
    

    public static int primeFactors(int n)
    
    {
        int res = 0;
      
        while (n%2==0)
        {
            res++;
            n /= 2;
        }
 
    
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
           
            while (n%i == 0)
            {
                  res++;
                n /= i;
            }
        }
 
   
        if (n > 2)
            res++;
        
        return res;
    }
    
    static long gcd(long a, long b)
{
    // Everything divides 0
    if (a == 0)
       return b;
    if (b == 0)
       return a;
  
    // base case
    if (a == b)
        return a;
  
    // a is greater
    if (a > b)
        return gcd(a-b, b);
    return gcd(a, b-a);
}

    static void swap(int A[], int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    static long pow(long a, long b) {
        long pow = 1;
        long x = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                pow = (pow * x) % mod;
            }
            x = (x * x) % mod;
            b /= 2;
        }
        return pow;
    }

    static boolean isPrime(long N) {
        if (N <= 1) {
            return false;
        }
        if (N <= 3) {
            return true;
        }
        if (N % 2 == 0 || N % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= N; i = i + 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static void print(char A[]) {
        for (char c : A) {
            out.print(c);
        }
        out.println();
    }

    static void print(boolean A[]) {
        for (boolean c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(int A[]) {
        for (int c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(long A[]) {
        for (long i : A) {
            out.print(i + " ");
        }
        out.println();

    }

    static void print(ArrayList<Integer> A) {
        for (int a : A) {
            out.print(a + " ");
        }
        out.println();
    }

    static int i() {
        return in.nextInt();
    }

    static long l() {
        return in.nextLong();
    }

    static String s() {
        return in.nextLine();
    }

    static int[] input(int N) {
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        return A;
    }

    static long[] inputLong(int N) {
        long A[] = new long[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = in.nextLong();
        }
        return A;
    }

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}