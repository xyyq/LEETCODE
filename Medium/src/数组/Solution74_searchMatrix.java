package 数组;

public class Solution74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0;
        int down = row - 1;
        while (up < down){
            int mid = up + (down - up) / 2;
            if (matrix[mid][col-1] > target){
                down = mid;
            }else if (matrix[mid][col-1] < target){
                up = mid + 1;
            }else {
                return true;
            }
        }
        int left = 0;
        int right = col - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (matrix[up][mid] > target){
                right = mid - 1;
            }else if (matrix[up][mid] < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
