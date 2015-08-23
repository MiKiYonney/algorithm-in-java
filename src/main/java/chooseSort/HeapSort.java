package chooseSort;

/**
 * 堆排序
 * O(nlogn)
 * 堆：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 二叉堆：
 * 1---父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
 * 2---每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
 * Created by yonney on 2015/7/22.
 */
public class HeapSort {
    //返回父节点
    public int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    //返回左孩子节点
    public int left(int i) {
        return 2 * i + 1;
    }

    //返回右孩子节点
    public int right(int i) {
        return 2 * i + 2;
    }

    //对以某一节点为根的字数做堆调整（最大堆）
    public void heapAdjust(int A[], int i, int heap_size) {
        int l = left(i);
        int r = right(i);
        int largest;
        int temp;
        if (l < heap_size && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heap_size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapAdjust(A, largest, heap_size);
        }
    }

    public void buildHeap(int A[],int heap_size){
        for(int i = (heap_size-2)/2;i >= 0;i--){
            heapAdjust(A,i,heap_size);
        }
    }

    public void print(int A[],int heap_size){
        for (int i = 0; i < heap_size; i++) {
            System.out.println(A[i]);
        }
        System.out.println();
    }

    void HeapSort(int A[], int heap_size){
        buildHeap(A,heap_size);
        int temp;
        for(int i = heap_size-1;i >=0;i--){
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapAdjust(A,0,i);
        }
        print(A,heap_size);
    }

    public static void main(String[] args) {
        int heap_size =13;
        int A[] = {19,1,10,14,16,4,7,9,3,2,8,5,11};
        new HeapSort().HeapSort(A,heap_size);
    }
}

