package 贪心;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution128_longestConsecutive {
    public static void main(String[] args) {
        System.out.println(new Solution128_longestConsecutive().longestConsecutive1(new int[]{1, 200, 3, 4, 5, 2}));
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int x:nums){
            set.add(x);
        }
        int maxLength=0;
        int currLength=0;
        for (int x:nums){
            if (!set.contains(x-1)){
                currLength =1;
                int curNum=x;
                while (set.contains(curNum+1)){
                    currLength++;
                    curNum++;
                }
                maxLength=Math.max(maxLength,currLength);
            }
        }
        return maxLength;
    }
    public int longestConsecutive1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            int len = left + right + 1;
            max = Math.max(max, len);
            map.put(nums[i], len);
            map.put(nums[i] - left, len);
            map.put(nums[i] + right, len);
        }
        return max;
    }

}
