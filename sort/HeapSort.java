package sort;

public class HeapSort {
    public static void heapSort(int[] array) {
        if(array == null || array.length == 1) return;
        //创建大根堆
        for(int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        //注意变量的数值和变量的意义应一致 还应注意++或者--的灵活使用
        int heapsize = array.length;
        swap(array, 0, --heapsize);
        while(heapsize > 0) {
            heapify(array, 0, --heapsize);
            swap(array, 0, heapsize);
        }
        
    }
    public static void heapInsert(int[] array, int i) {
        while(array[i] > array[(i-1)/2]) {
            swap(array, i, (i-1)/2);
            i = (i - 1) / 2;
        }
        
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void heapify(int[] array,int index,int heapsize) {
        int left = 2*index+1; // 先得出其左节点，在有左节点的前提下进行大小比较
        while(left < heapsize) {
            // 这里的比较很巧妙 若是右节点不存在或者左节点的值大于右节点结果取左节点 仅当右节点存在且值大于左节点才取右节点
            int largest = left+1 < heapsize && array[left] > array[left+1] ? left : left+1;
            if(array[index] < array[largest]) {
                swap(array, index, largest);
                index = largest;
            }
            else {
                break;
            }
            left = 2 * index + 1;
        }
    }
    // for test 此处应该随机创造若干数组去检验算法的准确性
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,2,6,1};
        heapSort(arr);
        for(int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
        
    }
}
