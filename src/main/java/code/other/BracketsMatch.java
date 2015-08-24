package code.other;

import java.util.Stack;

/**
 * 一个表达式字符串中包含了‘（’，')'，'['，']'，'{'，'}'六种括号，判断这些括号是否匹配。
 * 解决这个问题可以使用一种叫“栈”的数据结构，它是一种FILO（先进后出）的结构，插入（push，入栈）和删除（pop，出栈）元素都是在栈顶进行
 * Created by yonney.yang on 2015/8/24.
 */
public class BracketsMatch {
    public static boolean isValid(String str) {
        String left = "([{";
        String right = ")]}";
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (left.indexOf(ch) != -1) {
                stack.push(ch);
            }else if(right.indexOf(arr[i])!=-1) {
                if (!stack.isEmpty()) {
                   char temp = stack.pop();
                   if(ch != right.charAt(left.indexOf(temp))){
                        return false;
                   }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(BracketsMatch.isValid("{}[]{[]}"));
    }
}
