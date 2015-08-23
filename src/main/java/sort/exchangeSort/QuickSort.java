package sort.exchangeSort;

/**
 * Created by yonney.yang on 2015/8/21.
 */
public class QuickSort {
    public static int oneSort(int arr[], int low, int high) {
        int temp = arr[low];
        if (low < high) {
            while (low < high) {
                while (low < high && arr[high] > temp) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] < temp) {
                    low++;
                }
                arr[high] = arr[low];
            }
        }
        arr[low] = temp;
        return low;
    }

    public static void quickSort(int arr[], int low, int high) {
        if(low < high){
            int m = oneSort(arr, low, high);
            quickSort(arr, low, m - 1);
            quickSort(arr, m + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] list = {34, 3, 53, 2, 23, 7, 14, 10};
        QuickSort.quickSort(list,0,list.length-1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
