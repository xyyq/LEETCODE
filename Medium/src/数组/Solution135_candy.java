package 数组;

import java.util.Arrays;

public class Solution135_candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(new Solution135_candy().candy(ratings));
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int res = 0;
        int right = 1;
        Arrays.fill(left, 1);
        for (int i = 1; i < n ; i++) {
            if (ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >=0 ; i--) {
            if (ratings[i] > ratings[i + 1]){
                right++;
            }else {
                right = 1;
            }
            res += Math.max(right, left[i]);
        }
        res += left[n - 1];
        return res;
    }
    public int candy2(int[] ratings){
        int inc = 1, dec = 0, res = 1;
        int n = ratings.length;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings [i - 1]){
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            }else {
                dec++;
                if (dec == inc){
                    dec++;
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }
}
