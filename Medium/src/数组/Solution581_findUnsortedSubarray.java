package 数组;

public class Solution581_findUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums4={1,2,2,3,2,4,7,5,8,9};
        int[] nums={1,2,3,4,5,6};
        System.out.println(new Solution581_findUnsortedSubarray().findUnsortedSubarray1(nums4));
    }
    public int findUnsortedSubarray1(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;

    }
    public int findUnsortedSubarray(int[] nums) {
        int len=nums.length;
        int end =-1;
        int begin =0;
        int max=nums[0];
        int min=nums[len-1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>= max){
                max=nums[i];
            }else {
                end=i;//前面还有比当前大的就更新此右边界
            }
            if (nums[len-1-i]<=min){
                min=nums[len-1-i];
            }else {
                begin=len-1-i;//后面还有比当前小的数 更新此左边界
            }
        }
        return end-begin+1;
    }
}
