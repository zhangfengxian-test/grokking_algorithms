import java.util.Arrays;

public class SelectionSort2 {

    static int[] selectionSort(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            int smallest = findSmallest(arr);
            result[i] = arr[smallest];

            arr = getNewArrWithoutSmallest(arr, smallest);
        }
        return result;
    }

    private static int[] getNewArrWithoutSmallest(int[] arr, int smallest) {
        int[] newArrWithoutSmallest = new int[arr.length - 1];
        /*for (int i = 0; i < arr.length; i++) {
            if (i < smallest) {
                newArrWithoutSmallest[i] = arr[i];
            } else if (i > smallest) {
                newArrWithoutSmallest[i - 1] = arr[i];
            }
        }*/
        System.arraycopy(arr, 0, newArrWithoutSmallest, 0, smallest);
        System.arraycopy(arr, smallest + 1, newArrWithoutSmallest, smallest, arr.length - smallest - 1);
        return newArrWithoutSmallest;
    }

    private static int findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                selectionSort(new int[] {5, 3, 6, 2, 10})));
    }

}
