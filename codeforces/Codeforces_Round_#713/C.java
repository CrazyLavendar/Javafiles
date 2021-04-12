import java.util.Scanner;

public class C {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int testcase = 0; testcase < t; testcase++) {
            int a = scan.nextInt(), b = scan.nextInt();
            String word = scan.next();

            String ans = solve(a, b, word);
            System.out.println(ans);
        }
        scan.close();
    }

    private static String solve(int a, int b, String word) {

        int i = 0, j = word.length() - 1;

        char[] arr = word.toCharArray();

        for (; i < arr.length; i++) {
            if (arr[i] == '0')
                a--;
            else if (arr[i] == '1')
                b--;
        }

        i = 0;

        while (i < j) {

            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] == '0' && arr[j] == '?') {
                arr[j] = '0';
                a--;
                i++;
                j--;
            } else if (arr[i] == '1' && arr[j] == '?') {
                arr[j] = '1';
                b--;
                i++;
                j--;
            } else if (arr[j] == '0' && arr[i] == '?') {
                arr[i] = '0';
                a--;
                i++;
                j--;
            } else if (arr[j] == '1' && arr[i] == '?') {
                arr[i] = '1';
                b--;
                i++;
                j--;
            } else {
                i++;
                j--;
            }

        }

        i = 0;
        j = arr.length - 1;

        while (i <= j) {
            if (i != j) {
                if (arr[i] == arr[j] && arr[i] == '?') {
                    if (a > b) {
                        a -= 2;
                        arr[i] = '0';
                        arr[j] = '0';
                    } else {
                        b -= 2;
                        arr[i] = '1';
                        arr[j] = '1';
                    }
                }
            } else {
                if (arr[i] == arr[j] && arr[i] == '?') {
                    if (a > b) {
                        a -= 1;
                        arr[i] = '0';
                        arr[j] = '0';
                    } else {
                        b -= 1;
                        arr[i] = '1';
                        arr[j] = '1';
                    }
                }
            }
            i++;
            j--;
        }
        // System.out.println("hii2");
        if (a == 0 && b == 0 && palindrome(arr))
            return String.valueOf(arr);
        else
            return "-1";
    }

    private static boolean palindrome(char[] arr) {
        // System.out.println("hii");
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }
        return true;
    }
}
