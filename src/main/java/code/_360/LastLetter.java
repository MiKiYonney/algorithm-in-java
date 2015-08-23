package code._360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yonney on 2015/8/11.
 */
public class LastLetter {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String num = br.readLine();
            if (!num.matches("[0-9]+")) {
                br.close();
                return;
            }

            int n = Integer.valueOf(num);
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = br.readLine();
                if (!strings[i].matches("[a-zA-Z]+")) {
                    br.close();
                    return;
                }
            }

            for (String str : strings) {
                int index = findFirstOnceLetter(str);
                if (index != -1) {
                    System.out.println(str.charAt(index));
                }
            }

        } catch (IOException e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
    }

    public static int findFirstOnceLetter(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int len = str.length();
        char[] chars = str.toLowerCase().toCharArray();
        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            count[chars[i] - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
