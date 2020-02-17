package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
//        int left = 0, right = arr.length-1;
        sort(arr, 0, arr.length-1);
       
    }
    // 递归实现排序，要明白需要递归的是哪部分
    public static void sort(int[] arr, int left, int right) {
        if(left < right) {
//            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);  //加上此行则为随机快排
            int[] index = partition(arr, left, right);
            sort(arr, left, index[0]);
            sort(arr, index[1], right);
        }
    }
    //进行一次根据最后一个值进行小数放左边，大数放右边，等于放中间
    //可以改进（省掉一个变量num）：最后一个数先不动，作为标志位，然后大于它的数依次往前放，最后将最后一个数于大于此数的左边第一个数交换，如
    //[2,4,6,3,4]:4不动，2小于4，与第一个数交换，left指向arr[0]；4等于4，直接比较下一个；6大于4，与3交换；3小于4，与arr[1]交换
    //此时是[2,3,4,6,4],此时right指向arr[3],最后一个与当前right指向的数交换
    public static int[] partition(int[] arr, int left, int right ) {
        int index = left, num = arr[right];
        left--;
        right++;
        while(index < right) {
            if(arr[index] < num) {
                swap(arr, index, ++left);
            }else if (arr[index] > num) {
                swap(arr, index, --right);
                index--;
            }
            index++;
        }
        return new int[] {left, right};
        
    }
    public static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second]= tmp;
    }
    // for test
    public static int[] arrayGenerate(int len) {
        int[] arr = new int[len];
        for(int i = 0; i<len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }
    public static void main(String[] args) {
        for(int i =0; i < 10; i++) {
            int[] arr = arrayGenerate(10);
            quickSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
