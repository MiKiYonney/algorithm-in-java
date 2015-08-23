package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/11.
 * 合唱排列
 */
public class HeChang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inc1[] = new int[200],inc2[] = new int[200],a[] = new int[200];
        int n = scanner.nextInt();
        {
            int ans=0,i,j;
            for(i=1;i<=n;i++){
                a[i] = scanner.nextInt();
            }
            inc1[1]=1;
            for(i=2;i<=n;i++)
            {
                inc1[i]=1;
                for(j=1;j<i;j++)
                    if(a[i]>a[j]&&inc1[j]+1>inc1[i])
                        inc1[i]=inc1[j]+1;
            }
            inc2[n]=1;
            for(i=n-1;i>=1;i--)
            {
                inc2[i]=1;
                for(j=n;j>i;j--)
                    if(a[j]<a[i]&&inc2[j]+1>inc2[i])
                        inc2[i]=inc2[j]+1;
            }
            for(i=1;i<=n;i++)
                if(inc1[i]+inc2[i]-1>ans)
                    ans=inc1[i]+inc2[i]-1;

            System.out.println(n-ans);
        }
    }
}
