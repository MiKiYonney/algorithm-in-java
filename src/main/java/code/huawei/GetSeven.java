package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 */
public class GetSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(!input.matches("[0-9]+")){
            scanner.close();
            return;
        }

        int n = Integer.parseInt(input);
        int result = 0;
        for (int i = 1; i < n; i++) {
            if(i % 7 ==0){
                result++;
            }else {
                /*char[] chars = String.valueOf(i).toCharArray();
                for (char aChar : chars) {
                    if (aChar == '7') {
                        result++;
                        break;
                    }
                }*/
                int temp = i;
                while (temp >0 ){
                    if (temp % 10 == 7){
                        result++;
                        break;
                    }
                    temp /= 10;
                }
            }
        }
        System.out.println(result);
    }
}
