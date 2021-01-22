public class LinearSearchRecursion {
    public static void main(String[] args) {

        int[] array = { 1, 5, 8, 3, 55, 77, 909 };

        System.out.println(LinearFind(array, 909, 0));

    }

    static int LinearFind(int[] array, int item, int index) {

        if (index == array.length)
            return -1;

        if (array[index] == item)
            return index;
        else
            return LinearFind(array, item, ++index);

    }
}
