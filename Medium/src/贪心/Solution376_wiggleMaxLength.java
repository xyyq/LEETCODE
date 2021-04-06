package 贪心;

import java.util.Stack;

public class Solution376_wiggleMaxLength {
    public static void main(String[] args) {
        int[] nums={1,7,4,9,2,5};
        System.out.println(new Solution376_wiggleMaxLength().wiggleMaxLength(nums));
    }
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n<2) return n;
        int prevDiff=nums[1]-nums[0];
        int length=prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
           int diff=nums[i]-nums[i-1];
           if ((diff>0&&prevDiff<=0)||(diff<0&&prevDiff>=0)){
               length++;
               prevDiff=diff;
           }
        }
        return length;
    }
}
