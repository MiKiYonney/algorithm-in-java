package code.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 打印n对括号的全部有效组合
 * Created by yonney.yang on 2015/8/24.
 */
public class BracketsEffectCombination {
    public static void main(String[] args) {
        List<String> list = generate(2);
        System.out.println(list);
        System.out.println(list.size());
    }

    public static List<String> generate(int n) {
        char[] buffer = new char[n * 2];
        List<String> list = new ArrayList<String>();
        make(list, n, n, buffer, 0);
        return list;
    }

    /**
     * @param list     所有组合的容器
     * @param leftRem  左括号剩余数量
     * @param rightRem 右括号剩余数量
     * @param buffer   放括号的数组
     * @param count    插入括号的位置
     */
    private static void make(List<String> list, int leftRem, int rightRem, char[] buffer, int count) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(buffer));
        } else {
            if (leftRem > 0) {
                buffer[count] = '(';
                make(list, leftRem - 1, rightRem, buffer, count + 1);
            }
            if (rightRem > leftRem) {
                buffer[count] = ')';
                make(list, leftRem, rightRem - 1, buffer, count + 1);
            }
        }
    }


    //****************************************************
    public static HashSet<String> generateParens(int remaining){
        HashSet<String> set=new HashSet<String>();

        if(remaining==0)
            set.add("");
        else{
            HashSet<String> prev=generateParens(remaining-1);
            for(String str:prev){
                //括号内插入
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)=='('){
                        String s=insertInside(str,i);
                        set.add(s);//插入元素之前,HashSet会自动检查有无重复
                    }
                }
                //括号最前面插入
                if(!set.contains("()"+str))
                    set.add("()"+str);
            }
        }
        return set;
    }

    /**
     * 在每对括号内插入
     * @param str
     * @param leftIndex
     * @return
     */
    public static String insertInside(String str,int leftIndex){
        String left=str.substring(0,leftIndex+1);//左括号之后插入括号，所以需要leftIndex+1
        String right=str.substring(leftIndex+1);
        return left+"()"+right;
    }

}
