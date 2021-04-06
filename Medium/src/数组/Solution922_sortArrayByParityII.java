package 数组;

public class Solution922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {

        int odd=1, even=0;
        int n=A.length;
        while (odd<n&&even<n){
            while (even<n&& (A[even]&1)==0){
                even+=2;
            }
            while (odd<n&&(A[odd]&1)==1){
                odd+=2;
            }
            if (even<n&&odd<n){
                int tmp=A[odd];
                A[odd]=A[even];
                A[even]=tmp;
            }
        }
        return A;
    }
}
