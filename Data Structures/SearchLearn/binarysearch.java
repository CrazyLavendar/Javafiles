
public class binarysearch {

    public static void main(String[] args) {
        int[] intArray = { -22, -15, 1, 7, 20, 25, 55 };

        System.out.println(iterativeBinarySearch(intArray, 7));
        System.out.println(recuriveBinarySearch(intArray, 7));
    }

    public static int iterativeBinarySearch(int[] input, int value) {

        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == value)
                return midpoint;
            else if (input[midpoint] < value) { // search on right
                start = midpoint + 1;
            } else { // search on left
                end = midpoint;
            }
        }
        return -1;
    }

    public static int recuriveBinarySearch(int[] input, int value)

    {
        return recuriveBinarySearch(input, 0, input.length, value);
        // return recuriveBinarySearch(input, 0, input.length, value);
    }

    public static int recuriveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }
        int midpoint = (start + end) / 2;
        if (input[midpoint] == value) {
            return midpoint;
        }

        else if (input[midpoint] < value) {
            return recuriveBinarySearch(input, midpoint + 1, end, value);
        } else {
            return recuriveBinarySearch(input, start, midpoint - 1, value);
        }

    }
}