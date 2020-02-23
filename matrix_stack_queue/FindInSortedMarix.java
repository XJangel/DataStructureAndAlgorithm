package matrix_stack_queue;
/*
 * 给定一个有N*M的整形矩阵matrix和一个整数num，matrix的每一行以及每一列都是排好序的，实现一个函数，判断num是否在矩阵中
 * 要求：时间复杂度为O(M+N)，空间复杂度为O(1)
 * 
 * get：对于状况特殊的数据，最优解往往跟其状况相关，因此紧紧抓住条件，充分利用条件去解决问题。就会得到特殊解题思路。
 */
public class FindInSortedMarix {
    public static boolean findInSortedMatrix(int[][] matrix, int num) {
        int rBegin = 0, cBegin = matrix[0].length - 1;
//        for(int r = rBegin; r < matrix.length; r++) {
//            for(int c = cBegin; c >= 0; c--) {
        while(rBegin < matrix.length && cBegin >=0) {
            if(matrix[rBegin][cBegin] == num) {
                    return true;
                }else if (matrix[rBegin][cBegin] < num) {
                    rBegin++;
//                    break;
                }else {
                    cBegin--;
                }
        }
                
//            }
//        }
        return false;
        
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(findInSortedMatrix(matrix, K));
    }
}
