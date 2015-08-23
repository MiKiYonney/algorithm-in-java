package sort.insert;

/**
 * 希尔排序
 * 不稳定  O(n^2/3)
 * Created by yonney on 2015/7/22.
 */
public class ShellSort {
    public void shellSort(int data[]){
        int j = 0;
        int temp = 0;
        for(int inc = data.length/2;inc > 0; inc /=2){
            for(int i = inc ; i < data.length; i++){
                temp = data[i];
                for (j = i;j >= inc;j-= inc){
                    if (temp > data[j - inc]){
                        data[j] = data[j-inc];
                    }else {
                        break;
                    }
                }
                data[j] = temp;
            }

        }
    }
}
