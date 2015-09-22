package code.meituan;

/**
 * 纸币的组合数
 */
public class Solution {
    static int SUM_MAX = 1000000;
    static int NUM_MONEY = 6;

    public long getNumberOfCombinations(int N) {
        int i, j;
        int auiMoney[] = {1,  5, 10, 20, 50, 100};
        long aulAns[][] = new long[NUM_MONEY][SUM_MAX];

        for (i = 0; i <= N; i++) {
            aulAns[0][i] = 1;
        }
        for (i = 1; i < NUM_MONEY; i++) {
            for (j = 0; j <= N; j++) {
                if (j >= auiMoney[i]) {
                    aulAns[i][j] = aulAns[i][j - auiMoney[i]] + aulAns[i - 1][j];

                } else {
                    aulAns[i][j] = aulAns[i - 1][j];
                }
            }
        }
        return aulAns[NUM_MONEY - 1][N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getNumberOfCombinations(8));
    }
}
