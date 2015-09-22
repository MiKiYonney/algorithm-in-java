package leetcode;

import java.util.Arrays;

/**
 * Created by yonney.yang on 2015/3/27.
 */
public class SingleNumber {
    //思路1：对数组进行n*n循环 O(n^2) for-for
    //思路2：先排序，然后对相邻的元素进行比较 O(nLogN)~O(n^2)
    public int singleNumber1(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        for (int i = 1; i < A.length; i += 2) {
            if (A[i] != A[i - 1]) {
                return A[i - 1];
            }
        }
        return A[A.length - 1];
    }

    //思路3:一次遍历，O(n)  A XOR A = 0
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 5, 2, 4, 1};
        System.out.println(new SingleNumber().singleNumber(A));
    }
}
