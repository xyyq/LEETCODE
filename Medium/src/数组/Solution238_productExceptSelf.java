package 数组;

public class Solution238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int[] L=new int[length];
        int[] R=new int[length];
        int[] res=new int[length];
        L[0]=1;
        R[length-1]=1;
        for (int i = 1; i < length; i++) {
            L[i]=L[i-1]*nums[i-1];
            R[length-1-i]=R[length-i]*nums[length-i];
        }
        for (int i = 0; i < length; i++) {
            res[i]=L[i]*R[i];
        }
        return res;
    }
}
