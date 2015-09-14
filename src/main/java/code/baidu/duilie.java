package code.baidu;

import java.util.Scanner;

/**
 * Created by yonney on 2015/9/12.
 */
public class duilie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.next();
        if (!num.matches("[0-9]+")) {
            scanner.close();
            return;
        }
        int n = Integer.valueOf(num);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int out = scanner.nextInt();
            int in = scanner.nextInt();
            sum = sum + in;
            if (sum >= out) {
                sum = sum - out;
            }
            if(max < sum){
                max = sum;
            }
        }
        System.out.println(max);
    }
}
