package leetcode;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Created by yonney.yang on 2015/9/2.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{1, 2, 3}, 2));
    }
}
