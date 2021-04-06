package 数组;

public class Solution283_moveZeroes {
    public static void main(String[] args) {
        int[] nums={1,0,0,2,3};
        new Solution283_moveZeroes().moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
                int n=nums.length;
                if(nums==null||n==0) {
                    return;
                }
                int j=0;
                for(int i=0;i<n;i++){
                    if(nums[i]!=0){
                        if(i>j){
                            nums[j]=nums[i];
                            nums[i]=0;
                        }
                        j++;
                    }

                }

            }

}
