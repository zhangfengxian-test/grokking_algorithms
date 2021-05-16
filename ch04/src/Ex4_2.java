import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4.2 编写一个递归函数来计算列表包含的元素数。
 */
public class Ex4_2 {

    static int elementCount(List<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        return  1 + elementCount(arr.subList(1, arr.size()));
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 4, 6));
        System.out.println(elementCount(arr));
    }

}
