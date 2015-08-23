package code.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 * 描述
 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 给出多个名字，计算每个名字最大可能的“漂亮度”。
 知识点 字符串
 运行时间限制  0M
 内存限制    0
 输入
 整数N，后续N个名字
 N个字符串，每个表示一个名字

 输出
 每个名称可能的最大漂亮程度
 样例输入    2 zhangsan lisi
 样例输出    192 101
 */
public class NameBeautiful {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.next();
        if(!num.matches("[0-9]+"))
        {
            scanner.close();
            return;
        }
        int n = Integer.parseInt(num);
        String[] strings = new String[n];

        for (int i = 0; i < n; i++){
            strings[i] = scanner.next();
            if(!strings[i].matches("[a-zA-Z]+"))
            {
                scanner.close();
                return;
            }
            char[] str = strings[i].toCharArray();
            getNumber(str);
        }
    }

    private static void getNumber(char[] name) {
        int[] temp = new int[26];
        int number = 0;
        for(int i = 0;i < name.length;i++)
        {
            if(name[i] > 96)
                temp[name[i]-97]++;
            else
                temp[name[i]-65]++;
        }

        Arrays.sort(temp);
        for(int i = 26;i > 0; i--)
        {
            //差最小的*最大的数
            number += temp[i-1]*i;
        }

        System.out.println(number);
    }
}
