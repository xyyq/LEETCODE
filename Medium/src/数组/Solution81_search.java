package 数组;

public class Solution81_search {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int left = 0,right = n - 1,mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            if (nums[mid] > nums[left]){
                if (nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target > nums[mid] && nums[right] >= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
