package code._360;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 */
public class CunZhang
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.next();
        if(!num.matches("[0-9]+"))
        {
            scanner.close();
            return;
        }

        int group = Integer.parseInt(num);
        for(int i = 0 ; i < group;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int e[][] = new int[n+1][n+1];
            int od,maxOd =0,count=0;

            for (int j = 1 ;j <= m;j++){
                int i1 = scanner.nextInt();
                int i2 = scanner.nextInt();
                e[i1][i2] = 1;
                e[i2][i1] = 1;
            }

            for (int j = 1; j < n+1; j++) {
                od = 0;
                for (int k = 1; k < n+1; k++) {
                    od += e[j][k];
                }
                if(od > maxOd){
                    maxOd = od;
                    count = 1;
                }else if(od == maxOd){
                    count++;
                }
                System.out.println(j+"\n"+od);
            }

            System.out.println();
        }

    }
}
