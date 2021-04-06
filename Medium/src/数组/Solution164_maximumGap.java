package 数组;

public class Solution164_maximumGap {
    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(new Solution164_maximumGap().maximumGap(nums));
    }
    public int maximumGap(int[] nums) {
        int  min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=nums.length;
        int gap=0;
        for (int i = 0; i < n; i++) {
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        int[] sort=new int[max-min+1];
        for (int i = 0; i < n; i++) {
            sort[nums[i]-min]++;
        }
        int pre=0;
        for (int i = 1; i < sort.length; i++) {
            if (sort[i]!=0){
                gap=Math.max(gap,i-pre);
                pre=i;
            }
        }
        return pre;
    }
}
