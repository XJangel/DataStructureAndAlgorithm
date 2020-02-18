package sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) return arr;
        return mergesort(arr, 0, arr.length - 1);
    }
    public static int[] mergesort(int[] arr, int left, int right) {
        if(left == right) return new int[] {arr[left]};
        int mid = (left + right)/2;
        int[] arrLeft = mergesort(arr, left, mid);
        int[] arrRight = mergesort(arr, mid + 1, right);
        return merge(arrLeft, arrRight);
    }
    public static int[] merge(int[] left, int[] right) {
//        if(left == right) return new int[] {}
        int i = 0, j = 0, index = 0;
        int[] result = new int[left.length + right.length];
        while(i < left.length && j < right.length) {
            result[index++] = left[i] < right[j] ? left[i++] : right[j++]; 
        }
        if(i >= left.length) {
            while(j < right.length) {
                result[index++] = right[j++];
            }
        }else {
            while(i < left.length) {
                result[index++] = left[i++];
            }
        }
        return result;
    }
    
    // 改进的版本：降低空间复杂度，同时也比较符合排序的规则，在原顺序上排序，而不是将结果放在另一个数组
    public static void mergeSortUpadte(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
    
    // for test
    // 只是一个简单的test
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
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(mergeSort(arr)));
        }
    } 
}
