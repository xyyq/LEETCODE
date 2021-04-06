package 数组;

public class Solution153_findMin {
    public int findMin(int[] nums) {
        int n=nums.length;
        if (n==1||nums[0]<nums[n-1]) return nums[0];
        int l=0,r=n-1,mid;
        while (l<r){
            mid=(l+r)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }else if (nums[mid]<nums[mid+1]&&nums[mid]>nums[0]){
                l=mid+1;
            }else if (nums[mid]<nums[mid+1]&&nums[mid]<nums[0]){
                r=mid;
            }
        }
        return nums[l];
    }
}
