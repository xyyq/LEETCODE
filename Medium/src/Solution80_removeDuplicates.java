public class Solution80_removeDuplicates {

    public static void main(String[] args) {
        System.out.println(new Solution80_removeDuplicates().removeDuplicates(new int[]{1,1,1,2,2,3,3,3,3,3,4,4,4,4,5,5,5,5,6,6}));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 1;
        int curr = 1;
        int prev = nums[0];
        int length = 1;
        while (left < n){
            prev = nums[left - 1];
            if (nums[left] == prev){
                length++;
                if (length <= 2){
                    nums[curr] = nums[left];
                    curr++;
                }
            }else {
                length = 1;
                prev = nums[left];
                nums[curr] = nums[left];
                curr++;
            }
            left++;
        }
        return  curr;
    }
}
