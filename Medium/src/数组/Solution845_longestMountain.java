package 数组;

public class Solution845_longestMountain {
    public static void main(String[] args) {

    }
    public int longestMountain(int[] A) {
        int n= A.length;
        int dp[]=new int[n];

        int longest=0;
        for (int i = 1; i < n-1; i++) {
            if (A[i]>A[i-1]){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=0;
            }
            if (dp[i]>=1){
                int tmp=0;
                int count=dp[i]+1;
                while (i<(n-1)&&A[i]>A[i+1]){
                    tmp++;
                    i++;
                }
                if (tmp>=1&&count+tmp>=3){
                    longest=Math.max(longest,count+tmp);
                }
            }
        }
        return longest;
    }
}
