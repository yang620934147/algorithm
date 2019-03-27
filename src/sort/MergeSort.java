package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangxianyu
 * Date: 2019/3/27
 * Time: 下午12:38
 * Description:归并排序
 * 排序过程：

1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
4.重复步骤 3 直到某一指针到达序列尾
5.将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {

    public static void mergeSort(int[] arrays, int left, int right) {
//        如果数组还可以拆分
        if (left < right) {
            //数组的中间位置
            int middle = (left + right) / 2;
            //拆分左边数组
            mergeSort(arrays, left, middle);
            //拆分右边数组
            mergeSort(arrays, middle + 1, right);
            //合并
            merge(arrays, left, middle, right);

        }
    }


    /**
     * 合并数组
     */
    public static void merge(int[] arr, int left, int middle, int right) {
        //申请合并空间 大小为两个已经排序序列之和
        int[] temp = new int[right - left + 1];
        //i 和 j为两个已经排好序的数组的起始位置
        int i = left;
        int j = middle + 1;
        int k = 0;
        //排序
        while (i <= middle && j <= right) {
            //将比较小的数组放入合并空间
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //将左边剩余元素写入合并空间
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        //将右边剩余的元素写入合并空间
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //将排序后的数组写回原来的数组
        for (int l = 0; l < temp.length; l++) {
            arr[l + left] = temp[l];
        }

    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        mergeSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
