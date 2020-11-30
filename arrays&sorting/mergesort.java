public class mergesort { // inplace & stable
    public static void main(String[] args) {
        // int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int[] intArray = { 70, 80, 90, 55, 25, 35, 99, 88, 45, 62 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] array, int start, int end) {

        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        //
        System.out.println(start + " " + mid + " " + end);

        merge(array, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] array, int start, int mid, int end) {

        if (array[mid - 1] <= array[mid]) { // optimization .. from bottom to top
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i); // copy balance in same array
        System.arraycopy(temp, 0, array, start, tempIndex); // copy temp to array

    }

}
