package 数组;

public class Solution905_sortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int n=A.length;
        int left=0, right=n-1;
        while (left<right){
            while (left<right&&(A[left]&1)==0){
                left++;
            }
            while (left<right&&(A[right]&1)==1){
                right--;
            }
            if (left<right){
                int tmp=A[right];
                A[right]=A[left];
                A[left]=tmp;
            }
        }
        return A;
    }
}
