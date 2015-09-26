package code.didi;

/**
 * 最大子矩阵
 * Created by yonney on 2015/9/25.
 */
public class Main {
    public static void main(String[] args) {
        int a[][] = {
                {1,2,0,3,4},
                {2, 3, 4, 5, 1},
                { 1, 1, 5, 3 ,0}
        };
        System.out.println(maxSubSum2D(a,3,5)/2);
    }
    public static int maxSubSum2D(int[][] matrix, int N, int M) {
        int sum = Integer.MIN_VALUE;
        int[][] totalColSum = new int[N][M];
        int[] subColSum = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0)
                    totalColSum[i][j] = matrix[i][j];
                else
                    totalColSum[i][j] = totalColSum[i - 1][j] + matrix[i][j];
            }
        }
        for (int r = 0; r < N - 1; r++) {
            for (int k = r; k < N; k++) {
                if (r == 1 && k == 3) {
                    System.out.println("");
                }
                for (int j = 0; j < M; j++) {
                    if (r == k) {
                        subColSum[j] = matrix[r][j];
                    } else if (r == 0) {
                        subColSum[j] = totalColSum[k][j];
                    } else {
                        subColSum[j] = totalColSum[k][j] - totalColSum[r - 1][j];
                    }
                }
                sum = Math.max(sum, Main.maxSubSum(subColSum));
            }
        }
        return sum;
    }

    public static int maxSubSum(int[] a) {
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            } else if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
