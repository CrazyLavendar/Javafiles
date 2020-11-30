
public class quicksort {
    public static void main(String[] args) {
        int[] intArray = { 70, 80, 90, 55, 25, 35, 99, 88, 45, 62 };
        quicksortAlgo(intArray, 0, intArray.length - 1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void quicksortAlgo(int[] array, int start, int end) {
        if (start >= end)
            return;
        else {
            int pivotmid;
            pivotmid = partition(array, start, end);
            // System.out.println("\n Each pass " + pivotmid + " start " + start + " end "
            // + end);
            // for (int i = 0; i < array.length; i++) {
            // System.out.print(array[i] + " ");
            // }
            quicksortAlgo(array, start, pivotmid - 1);
            quicksortAlgo(array, pivotmid + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {

        int pivot = array[start];
        int i = start + 1;
        for (int j = i; j <= end; j++) {
            if (array[j] <= pivot) {
                swap(array, i++, j);
            }
        }
        swap(array, i - 1, start);
        return i - 1;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j)
            return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
