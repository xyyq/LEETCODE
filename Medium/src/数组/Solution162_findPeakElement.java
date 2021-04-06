package 数组;

public class Solution162_findPeakElement {
    public static void main(String[] args) {
        int[] nums={3,4,3,2,1};
        System.out.println(new Solution162_findPeakElement().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {

        int l=0,r=nums.length-1,mid;
        int n=nums.length;

        while (l<r){
            mid=(l+r)/2;
            if (nums[mid]>nums[mid+1]){
                 r=mid-1;
             }else {
                 l=mid+1;
             }
        }
        return l;
    }
}
