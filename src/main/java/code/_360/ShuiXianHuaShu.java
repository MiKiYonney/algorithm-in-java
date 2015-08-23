package code._360;

import java.util.Scanner;

public class ShuiXianHuaShu {
    public void solution(int m, int n) {
        if (m < 100 || n > 999) {
            System.out.println("no");
            return;
        }
        boolean flag = false;
        for (int t = m; t <= n; t++) {
            int a = t / 100;
            int b = (t % 100) / 10;
            int c = (t % 100) % 10;
            if (t == a * a * a + b * b * b + c * c * c) {
                if (flag) {
                    System.out.print(" ");
                }
                flag = true;
                System.out.print(t);
            }
        }

        if (!flag) {
            System.out.println("no");
        }else{
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m, n;
        boolean flag = false;
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();
           new ShuiXianHuaShu().solution(m, n);
        }
    }
}
