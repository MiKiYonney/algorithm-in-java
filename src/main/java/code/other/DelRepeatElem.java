package code.other;

import java.util.Arrays;

/**
 * 有一个已经排好序的数组，其中存在重复元素，请将重复元素删除掉，例如，A = [1, 1, 2, 2, 3]，处理之后的数组应当为A = [1, 2, 3]。
 * Created by yonney.yang on 2015/8/24.
 */

public class DelRepeatElem {
    public static int[] removeRepeatElem(int a[]) {
        // HashSet<Integer> set = new HashSet(new ArrayList(Arrays.asList(a)));
        if (a.length <= 1) {
            return a;
        }
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[index] != a[i]) {
               a[++index] = a[i];
            }
        }
        return Arrays.copyOf(a,index+1);
       /* int[] b = new int[index + 1];
        System.arraycopy(a, 0, b, 0, b.length);
        return b;*/
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3};
        a = removeRepeatElem(a);
        System.out.println(Arrays.toString(a));

    }
}
