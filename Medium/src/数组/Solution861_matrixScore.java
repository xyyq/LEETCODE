package 数组;

public class Solution861_matrixScore {
    public static void main(String[] args) {
        int[][] A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new Solution861_matrixScore().matrixScore(A));
    }
    public int matrixScore(int[][] A) {
        int row =A.length;
        int column=A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0]==0){
                for (int j = 0; j < column; j++) {
                    if (A[i][j]==0){
                        A[i][j]=1;
                    }else {
                        A[i][j]=0;
                    }
                }
            }
        }
        for (int i = 0; i < column; i++) {
            int count=0;
            for (int j = 0; j < row; j++) {
                if (A[j][i]==1){
                    count++;
                }
            }
            if (count<=row/2){
                for (int j = 0; j < row; j++) {
                    if (A[j][i]==0){
                        A[j][i]=1;
                    }else {
                        A[j][i]=0;
                    }
                }
            }

        }
        int res=0;
        for (int i = 0; i < row; i++) {
            int tmp=0;
            for (int j = 0; j < column; j++) {
                tmp+=(int) Math.pow(2,column-j-1)*A[i][j];
            }
            res+=tmp;
        }
        return res;
    }
}
