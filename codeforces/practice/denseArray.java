package codeforces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class denseArray {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String str[] = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(str[j]);

            solve(arr);
        }
        br.close();
    }

    private static void solve(int[] arr) {
        // System.out.println("hi 1");
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && unmatched(arr[i], arr[i - 1]))
                ans += populate(arr[i], arr[i - 1]);
        }
        System.out.println(ans);
    }

    public static boolean unmatched(int i, int j) {
        // System.out.println("hi 2");
        if (i == j)
            return false;

        int min = Math.min(i, j), max = Math.max(i, j);

        if (2 * min >= max)
            return false;

        return true;
    }

    public static int populate(int i, int j) {
        // System.out.println("hi 3");
        int min = Math.min(i, j), max = Math.max(i, j);
        int res = 0;
        while (2 * min < max) {
            min = (2 * min);
            res++;
        }
        return res;
    }

}