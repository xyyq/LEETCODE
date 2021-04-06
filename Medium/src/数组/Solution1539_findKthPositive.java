package 数组;

public class Solution1539_findKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int pre = arr[0];
        if (pre > k){
            return k;
        }
        k = k - pre + 1;
        int count = 1;
        while (count < n){
            if (arr[count] == pre + 1){
                pre++;
                count++;
            }else {
                k--;
                pre++;
                if (k == 0){
                    return pre;
                }
            }
        }
        return arr[count] + k;
    }
}
