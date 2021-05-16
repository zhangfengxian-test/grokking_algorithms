public class BinarySearch {

    static int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(list, 7));
        System.out.println(binarySearch(list, -1));
    }

    // 练习
    // 1.1 假设有一个包含128个名字的有序列表，你要使用二分查找在其中查找一个名字，请问最多需要几步才能找到？
    // log 128

    // 1.2 上面列表的长度翻倍后，最多需要几步？
    // log 256

}
