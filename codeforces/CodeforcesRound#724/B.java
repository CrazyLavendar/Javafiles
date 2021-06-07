/*Jayam Vimal - java template*/

import java.io.*;
import java.util.*;

public class B {
    
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    // static Pair[] moves = new Pair[] { new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1) };
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {

        // int t = i();
        // while (t-- > 0) {

        // int n = i();
        String w = s();

        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] c = w.toCharArray();

        // int currChar = 'a';
        int[] count = new int[26];

        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                System.out.println(abc[i]);
                return;
            }
        }

        String curr = "";
        while (true) {
            
            curr += abc[0];

            for (int i = 0; i < 26; i++) {
                
            if(interleave)
            
            }
        
        
        }
            


        

        // }


        out.flush();
    }

    public static String abcConv(int num , char[] abc) {
        
        String res = "";

        while (num >= 26) {
        
            char temp = abc[num % 26];

            res += temp;
            num /= 26;

        
        }


        return res;
    
    }



    public static boolean interleave(String s, char[] c) {
        
        StringBuilder str = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < c.length && j < s.length(); i++) {
        
            if (str.charAt(j) == c[i]) {
                j++;
                continue;
            }

            if(i == c.length -1)
                return false;

        }

        return true;
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