package 数组;

public class Solution633_judgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int len = (int) Math.sqrt(c);
        for (int i = 0; i < len; i++) {
            if (check((c - i*i))){
                return true;
            }
        }
        return false;
     }
    public boolean check(int m){
        if ((int) Math.sqrt(m)*(int)Math.sqrt(m) == m){
            return true;
        }
        return false;
    }
}
