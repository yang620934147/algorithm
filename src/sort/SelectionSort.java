package sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangxianyu
 * Date: 2019/3/21
 * Time: 上午11:55
 * Description: 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int loop = 1000000;
        int[] arr = new int[loop];
        for(int i=0;i<loop;i++){
            arr[i] = (int) (Math.random()*1000000);
        }

        long start1 = System.currentTimeMillis();

        sortByOneSide(arr);

        long spend1 = System.currentTimeMillis()-start1;
        System.out.println("方法一执行时间:"+spend1);

        long start2 = System.currentTimeMillis();

        sortByTwoSide(arr);

        long spend2 = System.currentTimeMillis()-start2;
        System.out.println("方法二执行时间:"+spend2);
    }

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
    }

    static void sortByTwoSide(int[] arr){
        for(int i=0,k=arr.length-1;i<=k;i++,k--){
            int minPosition = i;
            int maxPosition = i;
            for(int j=i+1,g=k-1; j<arr.length; j++,g--){
                minPosition = arr[j] < arr[minPosition]?j:minPosition;
                maxPosition = arr[g] < arr[maxPosition]?maxPosition:g;
            }

            int tmpmax = arr[k];
            arr[k] = arr[maxPosition];
            arr[maxPosition] = tmpmax;

            if(minPosition == k){
                int tmpmin = arr[i];
                arr[i] = arr[maxPosition];
                arr[maxPosition] = tmpmin;
            }else {
                int tmpmin = arr[i];
                arr[i] = arr[minPosition];
                arr[minPosition] = tmpmin;
            }

        }
    }
}
