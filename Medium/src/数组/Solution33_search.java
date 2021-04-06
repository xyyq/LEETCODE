package 数组;
/*
* 给你一个升序排列的整数数组 nums ，和一个整数 target 。

假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2] ）。

请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution33_search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid]==target) return mid;
            if (nums[0]<=nums[mid]){//左边有序
                if (nums[0]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if (nums[mid]<target&&target<=nums[n-1]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
