package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(new Solution03().lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ=new HashSet<Character>();
      /*  int rk=-1 ,ans=0;

        for (int i = 0; i < s.length(); i++) {
            if (i!=0){
                occ.remove(s.charAt(i-1));
            }
            while (rk+1<s.length()&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans=Math.max(ans,rk-i+1);
        }*/
        int left=0,right=0, ans=0;
        int n=s.length();
        while (left<n){
            if (left!=0){
                occ.remove(s.charAt(left-1));
            }
            while (right<n&&!occ.contains(s.charAt(right))){
                occ.add(s.charAt(right));
                right++;
            }
            ans=Math.max(ans,right-left);
            left++;
        }
        return ans;
    }
}
