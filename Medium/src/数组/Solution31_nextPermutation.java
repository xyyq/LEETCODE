package 数组;

import java.util.Arrays;

public class Solution31_nextPermutation {
    public static void main(String[] args) {
        int[] ins = {1,3,2};
        new Solution31_nextPermutation().nextPermutation(ins);
        System.out.println(Arrays.toString(ins));
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        for (int i = n-1 ; i>0 ; i--) {
                 int j=i-1;
                if (nums[i]>nums[j]){
                    int num=nums[j];//待交换的数
                    int k =n-1;
                    while (k>j){
                        if (nums[k]>num){
                            nums[j]=nums[k];
                            nums[k]=num;
                            break;
                        }else {
                            k--;
                        }
                    }
                    for (int l = i,m=n-1; l <m ; l++,m--) {
                        int tmp=nums[l];
                        nums[l]=nums[m];
                        nums[m]=tmp;
                    }
                    break;
                }
                if (i==1){
                    for (int k = 0,l=n-1; k <l ; k++,l--) {
                        int tmp=nums[l];
                        nums[l]=nums[k];
                        nums[k]=tmp;
                    }
                }
        }
    }
}
