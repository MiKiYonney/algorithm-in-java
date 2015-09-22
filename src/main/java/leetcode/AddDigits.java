package leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p/>
 * For example:
 * <p/>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Created by yonney.yang on 2015/9/2.
 */
public class AddDigits {
    public int addDigits(int num) {
        int result = num;
        while (true) {
            if (result < 10) {
                return result;
            }
            num = result;
            result = 0;
            while (num != 0) {
                result = result + num % 10;
                num = num / 10;
            }
        }
    }

    public int addDigits1(int num) {
        return 1 + (num-1) % 9;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }
}
