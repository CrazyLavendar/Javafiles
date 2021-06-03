/*Jayam Vimal - java template*/

import java.io.*;
import java.util.*;


public class C {
    
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    // static Pair[] moves = new Pair[] { new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1) };
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {

        // int t = i();
        // while (t-- > 0) {

        int n = i();
        Long[] A = new Long[n];
        for (int i = 0; i < n; i++)
            A[i] = l();
        
        long curr =0; // index , curr health


        PriorityQueue<Long> pq = new PriorityQueue<>();
        // pq.add(curr);

        for (int i =0; i < n; i++) {

            if (curr + A[i] >= 0) {
                pq.add(A[i]);
                curr += A[i];
            }
            else {
                if (pq.size() > 0  && pq.peek() < A[i]) {
                    curr -= pq.poll();
                    curr += A[i];
                    pq.add(A[i]);
                }
                    
            }
        }

        System.out.println(pq.size());

         


        



        

        // }


        // out.flush();
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