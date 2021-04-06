package 数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution493_reversePairs {
    public static void main(String[] args) {
        int[] nums={6,4,5,3,1,6,8,1};
        System.out.println(new Solution493_reversePairs().reversePairs1(nums));
    }

    public int reversePairs(int[] nums) {
        Set<Long> allNumbers = new TreeSet<Long>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int i = 0; i < nums.length; i++) {
            int left = values.get((long) nums[i] * 2), right = values.size() - 1;
            ret += bit.query(right + 1) - bit.query(left + 1);
            bit.update(values.get((long) nums[i]) + 1, 1);
        }
        return ret;
    }
    public int reversePairs1(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right) {
        if(left==right) return 0;
        int mid=left+(right-left)/2;
        int n1=reversePairsRecursive(nums,left,mid);
        int n2=reversePairsRecursive(nums,mid+1,right);
        int res=n1+n2;
        int i=left,j=mid+1;
        while (i<=mid){
            while (j<=right&&(long)nums[i]>2*nums[j]){
                j++;
            }
            res+=j-mid-1;
            i++;
        }
        int[] sorted=new int[right-left+1];
        int p1=left,p2=mid+1;
        int p=0;
        while (p1<=mid||p2<=right){
            if (p1>mid){
                sorted[p++]=nums[p2++];
            }else if (p2>right){
                sorted[p++]=nums[p1++];
            }else {
                if (nums[p1]<=nums[p2]){
                    sorted[p++]=nums[p1++];
                }else {
                    sorted[p++]=nums[p2++];
                }
            }
        }
        for (int k = 0; k < sorted.length; k++) {
            nums[left+k]=sorted[k];
        }
        return res;
    }

}


class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

}

