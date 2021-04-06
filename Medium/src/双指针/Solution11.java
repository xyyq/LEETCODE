package 双指针;

public class Solution11 {
    public static void main(String[] args) {
        int[] ints={1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(ints));
    }
    public int maxArea(int[] height) {
            int right=height.length-1,left=0;
            int ans=0;
            while (left<right){
                int l=height[left];
                int r=height[right];
                if (l<r){
                    ans=l*(right-left)>ans?l*(right-left):ans;
                    left++;
                }else {
                    ans=r*(right-left)>ans?r*(right-left):ans;
                    right--;
                }
            }
            return ans;
        }
}
