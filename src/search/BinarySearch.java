package search;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangxianyu
 * Date: 2019/3/27
 * Time: 下午1:17
 * Description:二分查找
 * 在计算机科学中，二分搜索（英语：binary search），也称折半搜索（英语：half-interval search）、对数搜索（英语：logarithmic search），
 * 是一种在有序数组中查找某一特定元素的搜索算法。搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。
 */
public class BinarySearch {
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            //如果相等 返回值
            if (key == arr[middle]) {
                return middle;
            } else if (key < arr[middle]) {
                //如果key小于中间值，那么改变high，值可能在左边部（比较小的部分）
                high = middle - 1;
            }else {
                //如果key大于中间值，那么改变low，值可能在右边部（比较大的部分）
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        System.out.println(search(ints, 4));
    }
}
