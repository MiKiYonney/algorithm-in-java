package leetcode;

/**
 * Created by yonney.yang on 2015/4/1.
 */
public class ExcelSheetColumnTitle {
    //1.映射Map
    public String convertToTitle1(int n) {
        String s = "";
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        n--;
        while (!(n <0 )){
            s = map.charAt(n%26)+s;
            n = n/26-1;
        }
        return s;
    }

    public String convertToTitle(int n) {
        String s = "";
        char temp;
        while(n != 0){
            n--;
            temp = (char) ('A'+n%26);
            s = temp +s;
            n /= 26;
        }
        return s;
    }
}
