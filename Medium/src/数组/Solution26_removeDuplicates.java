package 数组;

public class Solution26_removeDuplicates {
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution26_removeDuplicates().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1) return nums.length;
      /*int pre=nums[0]-1;
      int pos=0;
      int i;
        for ( i = 0; i < nums.length&&pos<nums.length; i++) {
            while (pos<nums.length&&nums[pos]==pre){
                pos++;
            }
            if (pos>=nums.length) break;
            if (pos<nums.length&&nums[pos]!=pre){
                nums[i]=nums[pos];
                pre=nums[i];
            }
        }
        return i;*/
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
