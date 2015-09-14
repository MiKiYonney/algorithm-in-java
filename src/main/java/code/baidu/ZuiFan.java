package code.baidu;

import java.util.Scanner;

/**
 * Created by yonney on 2015/9/12.
 */
public class ZuiFan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int c = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(countN(a, n, t, c));
    }

    static int countN(int data[], int size, int t, int c) {

        int s;
        int count = 0;
        for (int i = 0; i < size; i++) {
            s = data[i];
            for (int j = i+1; j < i + c && i + c < size; j++) {
                s += data[j];
            }
            if (s <= t) {
                count++;
            }
        }
        return count;
    }
}
