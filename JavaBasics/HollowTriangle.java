import java.util.Scanner;

public class HollowTriangle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        scan.close();
        int left = 1, right = r;
        for (int i = r; i > r / 2; i--) {
            if (i == r) {
                for (int x = 0; x < r; x++)
                    System.out.print("*");
                continue;
            } else {
                System.out.println("");
                left++;
                right--;
                for (int y = 1; y <= r; y++) {
                    if (y == left || y == right)
                        System.out.print("*");
                    else {
                        System.out.print(" ");
                    }
                }

            }

        }
    }
}
