package 数组;

import java.util.Arrays;

public class Solution1024_videoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0,1},{6,7},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,9},{2,5},{2,6},
        {3,4},{4,5},{5,7},{6,9}};

        System.out.println(new Solution1024_videoStitching().videoStitching(clips, 9));;
    }
    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;

    }

}
