package 数组;

public class Solution27_removeElement {

        public int removeElement(int[] nums, int val) {
            int  n = nums.length;
            int  left = 0, right = n - 1;
            int  res = n;
            while (left < right){
                if (nums[left] == val){
                    res--;
                    while (left < right && nums[right] == val){
                        right--;
                        res--;
                    }
                    nums[left] = nums[right];
                }
                left++;
            }
            return res;
        }
}
