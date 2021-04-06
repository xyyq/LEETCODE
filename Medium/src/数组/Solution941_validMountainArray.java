package 数组;

public class Solution941_validMountainArray {
    public boolean validMountainArray(int[] A) {
            int n=A.length;
            if (A==null||n<3) return false;
            int i=0;
            if (A[i]>=A[i+1]){
                return false;
            }else {
                while (i<n-2&&A[i]<A[i+1]){
                    i++;
                }
                while (i<n){
                    if (A[i]<=A[i+1]){
                        return false;
                    }
                }
            }
            return true;
    }
}
