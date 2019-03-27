package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangxianyu
 * Date: 2019/3/21
 * Time: 上午11:55
 * Description: 选择排序 时间复杂度O(n²)  空间复杂度O(1)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int loop = 100000;
        Random random = new Random();
        int[] arr = new int[loop];
        for(int i=0;i<loop;i++){
            arr[i] = random.nextInt(loop);
        }
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[arr.length];
        int[] arr4 = new int[arr.length];
        int[] arr5 = new int[arr.length];
        System.arraycopy(arr,0,arr1,0,arr.length);
        System.arraycopy(arr,0,arr2,0,arr.length);
        System.arraycopy(arr,0,arr3,0,arr.length);
        System.arraycopy(arr,0,arr4,0,arr.length);
        System.arraycopy(arr,0,arr5,0,arr.length);

        long start1 = System.currentTimeMillis();

        QuickSort.sort(arr1,0,arr1.length-1);

        long spend1 = System.currentTimeMillis()-start1;
        System.out.println("QuickSort执行时间:"+spend1);
        //printArr(arr1);


        long start2 = System.currentTimeMillis();

        MergeSort.mergeSort(arr2,0,arr2.length-1);

        long spend2 = System.currentTimeMillis()-start2;
        System.out.println("MergeSort执行时间:"+spend2);
        //printArr(arr2);

        long start3 = System.currentTimeMillis();

        Arrays.sort(arr3);

        long spend3 = System.currentTimeMillis()-start3;
        System.out.println("jdk自带方法执行时间:"+spend3);
        //printArr(arr3);

//        long start4 = System.currentTimeMillis();
//
//        InsertSort.sort(arr4);
//
//        long spend4 = System.currentTimeMillis()-start4;
//        System.out.println("InsertSort方法执行时间:"+spend4);
//
//        long start5 = System.currentTimeMillis();
//
//        BubbleSort.sort(arr5);
//
//        long spend5 = System.currentTimeMillis()-start5;
//        System.out.println("BubbleSort方法执行时间:"+spend5);
    }

    /**
     * 从一边排序
     * @param arr
     */
    static void sortByOneSide(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minPosition = i;

            for(int j=i+1; j<arr.length; j++){
                minPosition = arr[j] < arr[minPosition]?j:minPosition;
            }

            int tmpmax = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = tmpmax;
        }
        //printArr(arr);
    }

    /**
     * 两头排序
     * @param arr
     */
    static void sortByTwoSide(int[] arr){
        for(int i=0,k=arr.length-1;i<=k;i++,k--){
            int minPosition = i;
            int maxPosition = i;
            for(int j=i+1,g=k; j<k-1 && g>i; j++,g--){
                minPosition = arr[j] < arr[minPosition]?j:minPosition;
                maxPosition = arr[g] < arr[maxPosition]?maxPosition:g;
            }

            int tmpmax = arr[k];
            arr[k] = arr[maxPosition];
            arr[maxPosition] = tmpmax;

            int tmpmin = arr[i];
            //当最小的位置和要排的最大数的位置相等时,这个位置的数已经在上一步被替换了
            if(minPosition == k){
                arr[i] = arr[maxPosition];
                arr[maxPosition] = tmpmin;
            }else {
                arr[i] = arr[minPosition];
                arr[minPosition] = tmpmin;
            }
        }
        //printArr(arr);
    }

    static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
