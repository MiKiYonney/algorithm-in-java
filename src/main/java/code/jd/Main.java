package code.jd;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[][] = new int[6][6];
        int map[][] = new int[6][6];

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (i != 0 || j != 0) {
                    a[i][j] = scanner.nextInt();
                }
                if (i == 0 && j != 0){
                    a[i][j] += a[i][j - 1];
                }
                if (i != 0 && j == 0){
                    a[i][j] += a[i - 1][j];
                }
                if (i != 0 && j != 0){
                    a[i][j] += (a[i - 1][j] > a[i][j - 1]) ?
                            a[i - 1][j] : a[i][j - 1];
                }
            }
        }
        System.out.println(a[5][5]);
    }
}



