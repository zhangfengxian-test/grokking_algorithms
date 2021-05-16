import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4.1 请编写前述sum函数的代码。
 */
public class Ex4_1 {

    static int sum(List<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        return arr.get(0) + sum(arr.subList(1, arr.size()));
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 4, 6));
        System.out.println(sum(arr));
    }

}
