package 数组;

public class Solution42_trap {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < right){
            if (height[left] < height[right]){
                int lHeight = height[left];
                while (height[left] <= lHeight){
                    res += lHeight -height[left];
                    left++;
                }
            }else {
                int rHeight = height[right];
                while (height[right] <= rHeight){
                    res += rHeight - height[right];
                    right--;
                }
            }
        }
        return  res;
    }
}
