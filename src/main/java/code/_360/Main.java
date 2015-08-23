package code._360;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        float n, i;
        n = cin.nextFloat();
        while (n != 0 && n < 100) {
            float a = 0, b = 0, c = 0;
            while (n-- != 0) {
                i = cin.nextFloat();
                if (i < 0) {
                    a++;
                } else if (i == 0) {
                    b++;
                }else {
                    c++;
                }
            }
            System.out.println((int)a+" "+(int)b+" "+(int) c);
        }

    }
}
