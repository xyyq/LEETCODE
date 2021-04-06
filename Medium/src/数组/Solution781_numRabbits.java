package 数组;

import java.util.Arrays;

public class Solution781_numRabbits {
    public static void main(String[] args) {
        System.out.println( new Solution781_numRabbits().numRabbits(new int[]{1,1,1,1,1}));
    }
    public int numRabbits(int[] answers) {
        int  n = answers.length;
        int start = 0;
        Arrays.sort(answers);
        int  res = 0;
        while (start < n){
            int end = start;
            while (end < n && answers[end] == answers[start]){
                end++;
            }
            int  len = end -start;
            int m = len / (answers[start] + 1);
            int q = len % (answers[start] + 1);
            m =( m + (q == 0 ? 0 : 1));
            res += m * (answers[start] + 1);
            start = end;
        }
        return  res;
    }
}
