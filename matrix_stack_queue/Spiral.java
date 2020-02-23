package matrix_stack_queue;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public static List<Integer> spiral(int[][] matrix) {
        if(matrix ==null || matrix.length == 0) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int l = 0, r = matrix[0].length-1, top = 0, bottom = matrix.length-1;
        while(l <= r && top <= bottom) {
            for(int i = l; i<= r;i++) {
                list.add(matrix[l][i]);
            }
            top++;
            for(int j = top; j <= bottom; j++) {
                list.add(matrix[j][r]);
            }
            r--;
            if(l < r && top < bottom) {
                for(int i = r; i >= l;i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                for(int j = bottom; j >= top; j--) {
                    list.add(matrix[j][l]);
                }
                l++;
            }
        }
        
        return list;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,169}};
        List<Integer> list = spiral(matrix);
        for(Integer i:list) {
            System.out.print(i+" ");
        }
    }
}
