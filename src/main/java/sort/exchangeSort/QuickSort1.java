package sort.exchangeSort;

/**
 * 快速排序
 * 不稳定 O(nlogN)
 * Created by yonney on 2015/7/22.
 */
public class QuickSort1 {
    public void quickSortPartition(int data[], int low, int high) {
        int i, j;
        if (low < high) {
            i = low;
            j = high;
            data[0] = data[i];
            while (i != j) {
                while (data[j] > data[0] && i < j) {
                    j--;
                }
                if (i < j) {
                    data[i] = data[j];
                    i++;
                }
                while (data[i] < data[0] && i < j) {
                    i++;
                }
                if (i < j) {
                    data[j] = data[i];
                    j--;
                }
            }
            data[i] = data[0];
            quickSortPartition(data, low, i - 1);
            quickSortPartition(data, i + 1, high);
        }

    }

    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;

        if( i1 == i2){
            System.out.println("i1 == i2");
        }else{
            System.out.println("i1 != i2 ");
        }

        //大于127
        Integer i3 = 200;
        Integer i4 = 200;

        if( i3 == i4){
            System.out.println("i3 == i4");
        }else{
            System.out.println("i3 != i4 ");
        }
    }
    
}
