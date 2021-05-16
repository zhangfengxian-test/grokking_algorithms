import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    static List<Integer> selectionSort(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list.size());

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int smallest = findSmallest(list);
            result.add(list.get(smallest));

            list.remove(smallest);
        }
        return result;
    }

    private static int findSmallest(List<Integer> list) {
        int smallest = list.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(list));
    }

}
