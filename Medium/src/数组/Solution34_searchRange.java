package 数组;
/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是O(log n) 级别。

如果数组中不存在目标值，返回[-1, -1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution34_searchRange {
    public static void main(String[] args) {
        int[] nums = {1,1,2,13,13};
        System.out.println(new Solution34_searchRange().binSearchLeft(nums,13));
        System.out.println(new Solution34_searchRange().binSearchRight(nums,14));

    }
    public int[] searchRange(int[] nums, int target) {
        return nums;
    }
    public int binSearchLeft(int[] nums,int target){//左侧边界
        int length = nums.length;
        int left = 0, right = length-1;
        int mid;
        while (left<right){
            mid = (left+right)/2;
            if (target<nums[mid]){
                right = mid-1;
            }else if (target==nums[mid]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left]==target?left:-1;
    }
    public int binSearchRight(int[] nums,int target){//右侧边界
        int length = nums.length;
        int left = 0, right = length-1;
        int mid;
        while (left<right){
            mid = (left+right+1)/2;
            if (target<nums[mid]){
                right = mid-1;
            }else if (target==nums[mid]){
                left = mid;
            }else {
                left = mid+1;
            }
        }
        if ( nums[right] != target)
            return -1;
        return right;
    }
}
