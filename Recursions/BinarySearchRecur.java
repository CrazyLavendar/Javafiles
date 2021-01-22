public class BinarySearchRecur {
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println(BinaryFind(array, 7, 0, array.length - 1));

    }

    static int BinaryFind(int[] array, int item, int left, int right) {

        if (right < left)
            return -1;
        int midIndex = (left + right) / 2;

        if (array[midIndex] == item)
            return midIndex;
        else if (array[midIndex] > item)
            return BinaryFind(array, item, left, midIndex - 1);
        else
            return BinaryFind(array, item, midIndex + 1, right);

    }
}
