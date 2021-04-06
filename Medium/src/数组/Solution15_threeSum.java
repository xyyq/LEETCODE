package 数组;

import java.util.*;

public class Solution15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return res;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int left=i+1;
            int right=n-1;
            while (left<right){
                if (nums[left]+nums[right]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left<right&&nums[left]==nums[left+1]){
                        left+=1;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right-=1;
                    }
                    left+=1;
                    right-=1;
                }else if (nums[left]+nums[right]<target){
                    left+=1;
                }else {
                    right-=1;
                }
            }
        }
        return res;
    }
}
