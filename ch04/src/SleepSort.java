import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SleepSort {

    static List<Integer> sleepSort(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (final int item : list) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(item);
                        result.add(item);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 10, 5, 99));
        System.out.println(sleepSort(list));
    }

}
