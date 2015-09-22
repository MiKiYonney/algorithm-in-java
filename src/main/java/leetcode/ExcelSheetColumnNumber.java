package leetcode;

/**
 * Created by yonney.yang on 2015/4/11.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int colNumber = 0;
        for (int i = 0; i < s.length();i++){
            colNumber = colNumber * 26 + (s.charAt(i)-64);
        }
        return colNumber;
    }

    public static void main(String[] args) {
        new ExcelSheetColumnNumber().titleToNumber("AA");
    }
}
