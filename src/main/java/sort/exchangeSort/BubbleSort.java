package sort.exchangeSort;

import java.util.Arrays;

/**
 * 稳定 O(n^2)
 * Created by yonney on 2015/7/22.
 */
public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = i;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{4,3,1,2,8,2,1,3};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
