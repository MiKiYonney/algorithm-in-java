package code.aqiyi;

import java.util.Scanner;

/**
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位？
 * Created by yonney on 2015/9/26.
 */
public class Main2 {
    public static int main(int p) {
        boolean[] per = new boolean[p];
        for (int i = 0; i < per.length; i++) {
            per[i] = true;
        }

        int t = 0, len = per.length;
        while (len > 1) {
            for (int i = 0; i < per.length; i++) {

                if (per[i]) {
                    t++;
                    if (t == 3) {
                        t = 0;
                        per[i] = false;
                        len--;
                    }
                }
            }
        }
        for (int i = 0; i < per.length; i++) {
            if (per[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
