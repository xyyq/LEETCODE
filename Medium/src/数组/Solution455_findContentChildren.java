package 数组;

import java.util.Arrays;

public class Solution455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;
        int start = 0;
        for (int i = 0; i < gLength; i++) {

            if (search(s,start,g[i]) != -1) {
                start = search(s,start,g[i]) + 1;
            }else {
                return i;
            }
        }
        return gLength;
    }
    public int search(int[] s,int start,int target){
        int left = start;
        if (left>=s.length) return -1;
        int right = s.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (s[mid] > target) {
                right = mid;
            } else if (s[mid] < target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if (s[left]>=target) {
            return left;
        }else {
            return -1;
        }
    }
}
