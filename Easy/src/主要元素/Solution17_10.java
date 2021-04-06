package 主要元素;

public class Solution17_10 {
    public static void main(String[] args) {
        int[] nums={1,2,5,9,5,9,5,5};
        System.out.println(new Solution17_10().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int maj=-1;
        for (int c =0,i=0 ; i <nums.length ; i++) {
            if (0==c){
                maj=nums[i];
                c=1;
            }else {
                if (maj == nums[i]) {
                    c++;
                } else {
                    c--;
                }
            }
        }
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (maj==nums[i]){
                count++;
            }
        }
        if (count>nums.length/2){
            return maj;
        }else {
            return -1;
        }
    }
}
