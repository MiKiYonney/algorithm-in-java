package code.wangyi;

import java.util.Scanner;

/**
 * Created by yonney on 2015/9/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 0){
            System.out.println(0);
            return;
        }
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        int m = scanner.nextInt();
        long b[] = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextLong();
        }
        long min = a[0];
        for (int i = 1; i < n; i++) {
            if(a[i] < min){
                min = a[i];
            }
        }
        long sumA = 0,sumB =0;
        for(int i = 0; i < n;i++){
            if(a[i]-min >=0){
                sumA++;
            }
        }
        for(int i = 0; i < m;i++){
            if(b[i]-min >=0){
                sumB++;
            }
        }
        System.out.println(sumA-sumB);
    }
}
