package matrix_stack_queue;

class Spiral_II {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for(int i = 1; i <= (n+1)/2; i++){
            spiral(matrix, i);
        }
        return matrix;
    }
    // num表示第几圈，从1开始计数
    public static void spiral(int[][] matrix, int num){
        if(num == matrix.length/2+1){
            matrix[num-1][num-1] = matrix.length * matrix.length;
            return;
        }
        int bottom = matrix.length-num;
        int begin = (int)(Math.pow(matrix.length,2)) - (int)(Math.pow(matrix.length-num*2+2, 2)) + 1;
        for(int i = num-1; i < bottom; i++){
            matrix[num-1][i] = begin++;
        }
        for(int j = num-1; j < bottom; j++){
            matrix[j][bottom] = begin++;
        }
        for(int i = bottom; i > num -1; i--){
            matrix[bottom][i] = begin++;
        }
        for(int j = bottom; j > num-1; j--){
            matrix[j][num-1] = begin++;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for(int i = 0; i< matrix.length; i++ ) {
            for(int j = 0; j< matrix.length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
