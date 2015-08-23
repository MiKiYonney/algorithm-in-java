package chooseSort;

/**
 * 简单选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置(和第一个交换)，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * 不稳定  o(n^2) 比冒泡快
 * Created by yonney on 2015/7/22.
 */
public class SimpleSelectSort {
    public void simpleSelectSort(int data[],int len){
        int i,j,min,t;
        for(i = 0;i<len-1;i++){
            min = i;
            for(j = i+1;j <len;j++){
                if(data[min]>data[j]){
                    min = j;
                }
            }
            if(min != i){//交换
                t = data[min];
                data[min] = data[i];
                data[i] = t;
            }
        }
    }
}
