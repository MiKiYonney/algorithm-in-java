package code.other;

/**
 * 一个小孩上一个N级台阶的楼梯，他可以一次走1阶、2阶或3阶，那么走完N阶有多少种方式。
 * Created by yonney.yang on 2015/8/24.
 */
public class UpStairsCountWays {
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    /**
     * 动态规划优化递归
     * @param n
     * @return
     */
    public static int countWays2(int n) {
        int[] map = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = -1;
        }
        return countWays2(n, map);
    }

    public static int countWays2(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWays2(n - 1, map) + countWays2(n - 2, map)
                    + countWays2(n - 3, map);
            return map[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays2(13));
    }
}
