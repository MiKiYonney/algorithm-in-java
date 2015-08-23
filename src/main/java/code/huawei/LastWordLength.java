package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 * 最后一个单词的长度
 */
public class LastWordLength {
    public static void main(String[] args) {
        Scanner sci = new Scanner(System.in);
        String str = sci.nextLine();
        if (str != null){
            System.out.println(lengthOfLastWord(str.trim()));
        }
        sci.close();
    }

    public static int lengthOfLastWord(String s) {
        int i;
        int stringStart = -1;
        for(i=s.length()-1; i>=0; i--){
            if(stringStart!=-1 && s.charAt(i) == ' '){
                return stringStart-i;
            }
            else if(stringStart==-1 && s.charAt(i) != ' '){
                stringStart = i;
            }
        }
        if(stringStart!=-1 && i == -1){
            return stringStart+1;
        }
        return 0;
    }
}
