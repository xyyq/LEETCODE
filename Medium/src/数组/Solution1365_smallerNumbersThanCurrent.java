package 数组;

public class Solution1365_smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = 0; j < n; j++) {
                if (nums[i]>nums[j]){
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }
    public int[] smallerNumbersThanCurrent2(int[] nums){
        int n=nums.length;
        int[] cnt=new int[100];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            res[i]= nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }
}
