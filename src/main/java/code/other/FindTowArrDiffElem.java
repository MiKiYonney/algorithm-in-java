package code.other;

/**
 * Created by yonney.yang on 2015/8/24.
 */
public class FindTowArrDiffElem {
    public static void main(String[] args) {
        int[] a = {11, 34, 9, -4, 100, 98};
        int[] b = {34, 55, 11, 9, 100, -4, 98};

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            c ^= a[i] ^ b[i];
        }
        c ^=b[b.length -1];
        System.out.println(c);

        String s = "abc";
        int key = 0xAB;
        String temp = "";
        for(int i = 0, len = s.length(); i < len; i++) {
            temp += (char)(s.charAt(i) ^ key);
        }
        System.out.println(temp);
    }
}
