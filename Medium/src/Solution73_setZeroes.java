import java.util.HashSet;

public class Solution73_setZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet setCol = new HashSet();
        HashSet setRow = new HashSet();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    setCol.add(i);
                    setCol.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (setCol.contains(i) || setRow.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
