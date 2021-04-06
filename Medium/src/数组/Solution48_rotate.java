package 数组;

import java.util.Arrays;

public class Solution48_rotate {
    public static void main(String[] args) {
        int[][] matrix = {{ 5, 1, 9,11},
                          {2, 4, 8,10},
                          {13, 3, 6, 7},
                          {15,14,12,16}};
        new Solution48_rotate().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length/2; i++) {//层数
            int t = matrix[0].length-i-1;
            for (int j = i; j <t ; j++) {
                int leftUp = matrix[i][j];
                int rightUp = matrix[j][t];
                int  rightDown = matrix[t][t-j+i];
                int leftDown = matrix[t-j+i][i];
                int tmp = leftDown;
                matrix[t-j+i][i] = rightDown;
                matrix[t][t-j+i] = rightUp;
                matrix[j][t] = leftUp;
                matrix[i][j] = tmp;
            }
        }
    }
}
