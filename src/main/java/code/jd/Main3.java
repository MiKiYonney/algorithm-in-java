package code.jd;

import java.util.Scanner;

/**
 * Created by yonney on 2015/9/18.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int monkey=1;
        int peaches=1;
        int peach=1;

        while(monkey<=n)
        {
            if(peach%n==1&&peach/n!=0)
            {
                peach=(peach/n)*(n-1);
                monkey++;
            }
            else
            {
                peaches++;
                peach=peaches;
                monkey=1;
            }
        }
        System.out.println(peaches);
    }

}