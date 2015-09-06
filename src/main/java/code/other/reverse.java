package code.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yonney.yang on 2015/8/28.
 */
public class reverse {
    public void swap(char[] arr, int begin, int end) {
        while(begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
    //I love java
    public String swapWords(String str) {
        char[] arr = str.toCharArray();
        swap(arr, 0, arr.length - 1);
        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                swap(arr, begin, i - 1);
                begin = i + 1;
            }
        }
        return new String(arr);
    }

    public static String swap(String str){
        String[] sArr = str.split(" ");
        List<String> list =Arrays.asList(sArr);
        Collections.reverse(list);
        String res = "";
        for (String s : list){
            res += s+" ";
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "I love java";
        System.out.println(new reverse().swapWords(str));
        System.out.println(swap(str));
    }
}
