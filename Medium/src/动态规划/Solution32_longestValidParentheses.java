package 动态规划;

public class Solution32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        int l=0;
        int r=0;
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c=='('){
                l++;
            }else {
                r++;
            }
            if (r==l){
                res=Math.max(res,2*l);
            }if (r>l){
                l=0;
                r=0;
            }
        }
        l=r=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            char c=s.charAt(i);
            if (c=='('){
                l++;
            }else {
                r++;
            }
            if (r==l){
                res=Math.max(res,2*l);
            }else if (l>r){
                l=0;
                r=0;
            }
        }
        return  res;
    }
}
