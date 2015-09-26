package code.aqiyi;

/**
 * 在一个字符串中查出第一个只出现一次的字符
 * Created by yonney on 2015/9/26.
 */
public class Main {
    public static char firstOne(String s)
    {
        char result = '0';
        char temp;
        int[] num = new int[52];
        for (int i = 0; i < s.length(); i ++)
        {
            temp = s.charAt(i);
            if ( temp >= 'a' && temp <= 'z' )
            {
                num[temp - 'a']++;
            }
            else
            if (temp >= 'A' && temp <= 'Z')
            {
                num[temp - 'A' + 26] ++;
            }
        }
        for (int i = 0; i < num.length; i ++)
        {
            if (num[i] == 1)
            {
                if (i >= 0 && i <=26)
                {
                    result = (char)(i + 'a');
                }
                else
                    result = (char)(i - 26 + 'A');
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstOne(s);
        System.out.println(c);
    }
}
