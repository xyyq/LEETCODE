package 数组;

public class Solution713_numSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums  ={10,5,6,3,3,4,5};
        System.out.println(new Solution713_numSubarrayProductLessThanK().numSubarrayProductLessThanK(nums,0));
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) return 0;
        int left=0 ,tmp=1, res=0;
        for (int right = 0; right < nums.length; right++) {
            tmp =tmp*nums[right];
            while (tmp>=k){
                tmp/=nums[left];
                left++;
            }
           res+=right-left+1;
        }
        return res;
    }
}
