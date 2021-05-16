import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int pivot = list.get(0);
        List<Integer> less = findLess(list.subList(1, list.size()), pivot);
        List<Integer> greater = findGreater(list.subList(1, list.size()), pivot);

        List<Integer> result = new ArrayList<>(1 + less.size() + greater.size());
        result.addAll(quickSort(less));
        result.add(pivot);
        result.addAll(quickSort(greater));
        return result;
    }

    private static List<Integer> findLess(List<Integer> list, int pivot) {
        List<Integer> less = new ArrayList<>();
        for (int item : list) {
            if (item <= pivot) {
                less.add(item);
            }
        }
        return less;
    }

    private static List<Integer> findGreater(List<Integer> list, int pivot) {
        List<Integer> greater = new ArrayList<>();
        for (int item : list) {
            if (item > pivot) {
                greater.add(item);
            }
        }
        return greater;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 1, 4, 5));
        System.out.println(quickSort(list));
    }

}
