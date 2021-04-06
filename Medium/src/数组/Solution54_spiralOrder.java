package 数组;

import java.util.ArrayList;
import java.util.List;

public class Solution54_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{ 5,1,9},
                           {2,4,8},
                           {1,3,6},
                            {1,3,6},

                };
        List<Integer> s=new Solution54_spiralOrder().spiralOrder(matrix);
        System.out.println(s);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows= matrix.length;
        int columns=matrix[0].length;
        List<Integer>  order=new ArrayList<>();
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left<=right&&top<=bottom){
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top+1; row <=bottom ; row++) {
                order.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return  order;
    }
}
