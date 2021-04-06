package 数组;

public class Solution_reversePairs {
    public static void main(String[] args) {
        int[] nums = {18,5,6,4,12,1,51,1,1,3,31,5,1,3,1,51,3};
        System.out.println(new Solution_reversePairs().reversePairs(nums));
    }

    static int res = 0;
    static int ret = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        sort(nums,0, n - 1,tmp);
        return ret;
    }
    public  void sort(int[] nums, int l, int r, int[] tmp){
        if (l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, tmp);
        sort(nums, mid + 1, r, tmp);
        merge(nums,l,mid,r,tmp);
    }
    public void merge(int[] nums, int l, int mid, int r, int[] tmp){
        for (int i = l; i <= r; i++) {
            tmp[i] = nums[i];
        }
        int i = l;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= r && (long) nums[i] > 2 * (long) nums[j]) j++;
            ret += (j - mid - 1);
            i++;
        }

        i = l;
        j = mid +1;
        for (int k = l; k <= r; k++) {
            if (i == mid + 1){
                nums[k] = tmp[j];
                j++;
            }else if (j == r + 1){
                nums[k] = tmp[i];
                i++;
            }else if (tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i++;
            }else {
                res += (mid - i +1);
                nums[k] = tmp[j];
                j++;
            }
        }
        return ;
    }

}
