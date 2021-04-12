import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for (int testcase = 0; testcase < t; testcase++) {
            int n = scan.nextInt();

            char[][] arr = new char[n][n];

            int x = 0;
            int[][] mark = new int[2][2];
            for (int i = 0; i < n; i++) {
                String temp = scan.next();
                // System.out.println(temp);
                // char[] row = temp.toCharArray();

                for (int j = 0; j < n; j++) {
                    arr[i][j] = temp.charAt(j);
                    if (temp.charAt(j) == '*') {
                        mark[x][0] = i;
                        mark[x][1] = j;
                        x++;
                    }
                }
            }

            solve(mark, arr);
            printArr(arr);
        }
        // System.out.println(mark[0][0] + " " + mark[0][1] + " " + mark[1][0] + " " +
        // mark[1][1]);
        scan.close();
    }

    private static void printArr(char[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    private static void solve(int[][] mark, char[][] arr) {
        if (mark[0][0] == mark[1][0]) {
            if (mark[0][0] == 0) {
                arr[1][mark[0][1]] = '*';
                arr[1][mark[1][1]] = '*';
            } else {
                arr[0][mark[0][1]] = '*';
                arr[0][mark[1][1]] = '*';
            }
        } else if (mark[0][1] == mark[1][1]) {
            if (mark[0][1] == 0) {
                arr[mark[0][0]][1] = '*';
                arr[mark[1][0]][1] = '*';
            } else {
                arr[mark[0][0]][0] = '*';
                arr[mark[1][0]][0] = '*';
            }
        } else {
            arr[mark[0][0]][mark[1][1]] = '*';
            arr[mark[1][0]][mark[0][1]] = '*';
        }

    }
}
