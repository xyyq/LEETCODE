package 数组;

public class Solution91_numDecodings {
    public static void main(String[] args) {
        System.out.println(new Solution91_numDecodings().numDecodings("2611055971756562"));
    }
    public int numDecodings(String s) {
        int length = s.length();
        if (s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            char c= s.charAt(i - 1);
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)){
                dp[i] += dp[i - 2];
            }
        }
        return dp[length ];
    }

}
