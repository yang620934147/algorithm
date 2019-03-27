package search;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangxianyu
 * Date: 2019/3/27
 * Time: 下午1:16
 * Description:线性搜索
 * 线性搜索或顺序搜索是一种寻找某一特定值的搜索算法，指按一定的顺序检查数组中每一个元素，直到找到所要寻找的特定值为止。
 * 是最简单的一种搜索算法。
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        System.out.println(search(ints, 4));
    }

    public static int search(int[] arr, int key) {
        //循环
        for (int i = 0; i < arr.length; i++) {
            //比较是否等于key
            if (arr[i] == key) {
                return i;
            }
        }
        //找不到就返回-1
        return -1;
    }
}
