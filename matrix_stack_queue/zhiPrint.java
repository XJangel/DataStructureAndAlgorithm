package matrix_stack_queue;

import java.io.PrintStream;
/*
 * “之”字形打印矩阵
 * 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 打印结果为：1 5 2 3 6 9 10 7 4 8 11 12，当然1 2 5 9 6 3 4 7 10 11 8 12也是可以的
 * 要求：额外空间复杂度为：O(1)
 */
public class zhiPrint {
    public static void zhiPrint(int[][] matrix) {
        if(matrix.length == 0) return;
        int tR = 0, tC = 0, bR = 0, bC = 0;
        boolean flag = true;
        while(tR < matrix.length && tC < matrix[0].length) {
            // 
            printSlant(matrix, tR, tC, bR, bC, flag);
            tR = tC == matrix[0].length-1 ? tR+1 : tR;
            tC = tC == matrix[0].length-1 ? tC :tC+1;
            bC = bR == matrix.length-1? bC+1 : bC;
            bR = bR == matrix.length-1? bR : bR+1;
            flag = !flag;
        }
    }
    public static void printSlant(int[][] matrix, int tR, int tC, int bR, int bC, boolean flag) {
        if(flag) {
            while(tR != bR+1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        }else {
            while(bR != tR-1) {
                System.out.print(matrix[bR--][bC++] + " ");
            }
        }
        System.out.println();
    }
    
    // for test
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zhiPrint(matrix);

    }
}
