package 回文串;
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution05 {
    public static void main(String[] args) {
            String s="babad";
        System.out.println(new Solution05().longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
       /* int n=s.length();
       暴力求解
        int longest=0;
        String res="";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s.substring(i,j))&&(j-i+1)>longest){
                        res=s.substring(i,j);
                        longest=j-i+1;
                    }
                }
            }
        return res;*/
        int n=s.length();
        boolean[][] dp=new boolean[n][n];// 子串 i-j是否回文
        String res="";
        for (int l = 1; l <=n; l++) {
            for (int i = 0; i+l-1< n; i++) {
                int j=i+l-1;
                if (1==l){
                    dp[i][j]=true;
                }else if (2==l){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else {
                    dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
                if (dp[i][j]&&l>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
        }

    public static boolean isPalindrome(String s){
        int n=s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
