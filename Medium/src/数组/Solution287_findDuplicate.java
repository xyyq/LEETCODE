package 数组;

public class Solution287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int l =1;
        int r =n-1;
        while (l < r){
            int mid=(l + r)/2;
            int cnt=0;
            for (int x:nums){
                if (x<=mid){
                    cnt++;
                }
            }
            if (cnt>mid){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
}
