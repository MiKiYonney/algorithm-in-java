package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 * Lily的画按顺序排列
 */
public class LilyPicture {
    public static void main(String[] args) {
        Scanner sci = new Scanner(System.in);
        String str = sci.nextLine();
        char[] strChar = str.toCharArray();

        if (str != null && strChar.length <= 1024) {
            int N = strChar.length;
            for (int i = 0; i < N; i++) {
                char temp;
                for (int j = i + 1; j < N; j++) {
                    if (strChar[i] > strChar[j]) {
                        temp = strChar[i];
                        strChar[i] = strChar[j];
                        strChar[j] = temp;
                    }
                }
            }
        }
        System.out.println(strChar);
    }
}
