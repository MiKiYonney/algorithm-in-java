package leetcode;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p/>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Created by yonney on 2015/9/22.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length){
            nums[j++] = 0;
        }
    }

    public void moveZeroesToTop(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = nums.length-1;
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i] != 0) {
                nums[j--] = nums[i];
            }
        }
        while (j >=0){
            nums[j--] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroesToTop(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
