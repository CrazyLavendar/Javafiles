import java.util.ArrayList;
import java.util.Arrays;

public class jdksort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        Arrays.sort(intArray);
        // Arrays.parallelSort(intArray); it uses threads

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
