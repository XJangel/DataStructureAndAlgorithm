package matrix_stack_queue;

public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] matrix){
        if(matrix.length < 2) {
            return matrix;
        }
        int m = 0, n = matrix.length - 1;
        while(m <= n) {
            rotateEdge(matrix, m++, n--);
        }
        return matrix;
    }
    public static void rotateEdge(int[][] matrix, int m, int n) {
        int l = m, r = n;
        for(int i = 0; i < n-m; i++) {
            int tmp = matrix[l][l+i];
            matrix[l][l+i] = matrix[n-i][l];
            matrix[n-i][l] = matrix[n][n-i];
            matrix[n][n-i] = matrix[l+i][n];
            matrix[l+i][n] = tmp;
        }
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }


}
