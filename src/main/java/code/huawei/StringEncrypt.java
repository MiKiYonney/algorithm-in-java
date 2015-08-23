package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/12.
 * 描述:有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词死于字母表的下面，
 *
 */
public class StringEncrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyInput = scanner.nextLine();
        String strInput = scanner.nextLine();

        char key[] = keyInput.toCharArray();
        char data[] = strInput.toCharArray();

        char encrypt[] = new char[data.length];
        Encrypt(key, data, encrypt);

        System.out.println(encrypt);
        scanner.close();
    }

    static void Encrypt(char key[], char data[], char encrypt[]) {
        char keych[] = new char[data.length];
        keych[0] = key[0];
        int i, j = 0, k = 0, flag;
        for (i = 0; key[i] != '\0'; i++) {
            flag = 1;
            for (k = 0; k < j + 1; k++) {
                if (key[i] == keych[k])
                    flag = 0;
            }
            if (flag != 0) {
                j = j + 1;
                keych[j] = key[i];
            }
        }
        int len;
        len = j + 1;
        char Alph[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (i = 0; Alph[i] != '\0'; i++) {
            flag = 1;
            for (k = 0; k < len; k++) {
                if (Alph[i] == keych[k])
                    flag = 0;
                if (Alph[i] == keych[k] - 32) {
                    keych[k] = (char) (keych[k] - 32);
                    flag = 0;
                }
            }
            if (flag != 0) {
                keych[len] = Alph[i];
                len = len + 1;
            }
        }
        keych[len] = '\0';
        i = 0;
        k = 0;
        while (data[i] != '\0') {
            if ((data[i] >= 'A' && data[i] <= 'Z') || (data[i] >= 'a' && data[i] <= 'z')) {
                for (j = 0; j < 26; j++) {
                    if ((data[i] == Alph[j]) || (data[i] - 32 == Alph[j])) {
                        if (data[i] >= 'A' && data[i] <= 'Z')
                            encrypt[k] = keych[j];
                        else
                            encrypt[k] = (char) (keych[j] + 32);
                        break;
                    }
                }
            } else
                encrypt[k] = data[i];
            i = i + 1;
            k = k + 1;
        }
        encrypt[k] = '\0';
    }
}
