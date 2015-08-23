package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/12.
 * 蛇形矩阵
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        int array[][] = new int[N][N];
        int temp = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i; j >=0; j--) {
                array[j][i-j] = temp++;
            }
        }
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N - i; j++)
            {
                System.out.print(array[i][j]);
                if(j != N-i-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
