package sort.insert;

/**
 * 插入排序
 * Created by yonney.yang on 2015/8/21.
 */
public class InsertSort {
    //直接插入排序
    public static void insertSort(int arr[]) {
        int temp;
        int j;
        for (int i = 1; i <= arr.length - 1; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    //二分插入排序
    public static void binaryInsertSort(int arr[]) {
        int key, left, right, middle;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            left = 0;
            right = i - 1;
            while (left <= right) {
                middle = (left + right) / 2;
                if (arr[middle] > key) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }

            arr[left] = key;
        }
    }

    //希尔排序
    public static void shellSort(int arr[]){
        int temp,j,gap = 0;
        while (gap <= arr.length-1){
            gap = gap*3+1;
        }
        while (gap > 0){
            for (int i = gap;i < arr.length-1;i++){
                j = i - gap;
                temp = arr[i];
                while (( j >= 0 ) && ( arr[j] > temp )){
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = temp;
            }
            gap = ( gap - 1 ) / 3;
        }

    }

    public static void main(String[] args) {
        int[] list = {25,19,6,58,34,10,7,98,160,0};
//        InsertSort.insertSort(list);
//        InsertSort.binaryInsertSort(list);
        InsertSort.shellSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
