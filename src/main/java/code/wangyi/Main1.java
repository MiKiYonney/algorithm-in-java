package code.wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long l = scanner.nextLong();
        long a[] = new long[n];
        for(int i=0; i< n;i++){
            long input = scanner.nextLong();
            if(0 <= input && input <=l){
                a[i] = input;
            }else{
                return;
            }
        }
        quickSort(a, 0, a.length - 1);
        long max = 0;
        for (int i = n-1; i >=1 ;i--){
            long temp = a[i]-a[i-1];
            if(temp > max){
                max = temp;
            }
        }
        long t = Math.max(a[0],l-a[n-1]);
        DecimalFormat df  = new DecimalFormat("###.00");
        System.out.println(df.format((Math.max(t,(double)max/2))));
    }


    public static int oneSort(long arr[], int low, int high) {
        long temp = arr[low];
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

    public static void quickSort(long arr[], int low, int high) {
        if(low < high){
            int m = oneSort(arr, low, high);
            quickSort(arr, low, m - 1);
            quickSort(arr, m + 1, high);
        }
    }
}
