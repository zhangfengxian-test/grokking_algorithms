import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4.3 找出列表中最大的数字。
 */
public class Ex4_3 {

    static int max(List<Integer> list) {
        if (list.size() == 2) {
            return list.get(0) > list.get(1) ? list.get(0) : list.get(1);
        }
        int subMax = max(list.subList(1, list.size()));
        return list.get(0) > subMax ? list.get(0) : subMax;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 1));
        System.out.println(max(list));
    }

}
