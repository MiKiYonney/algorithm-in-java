package code.meituan;

public class Solution1 {
    public int limitedMaxSum(int[] arr, int length, int limit) {
        int size = arr.length;
        int hash[] = new int[size];
        int max = 0;
        for(int i = 0; i < size; i++) {
            hash[arr[i]%size] = 1;
        }

        for(int i = 0; i < size; i++) {
            int tmp = limit-arr[i];
            if((tmp > arr[i]) && (hash[tmp%size] == 1)){
                System.out.println(arr[i] + " " + tmp);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1};
        System.out.println(new Solution1().limitedMaxSum1(arr,1,2));
    }

    public int limitedMaxSum1(int[] arr, int length, int limit) {
        int first = 0;
        int last = length -1;
        int s = 0;
        int max = 0;
        for(int i=0 ;i<=last;i++){
            for(int j=0 ;j<=last;j++){
                s = arr[i] + arr[j];
                if(s<=limit){
                    if(max <s){
                        max = s;
                    }
                }
            }
        }
        return max;
    }
}
