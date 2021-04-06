package 数组;

public class Solution9_isPalindrome {
    public boolean isPalindrome(int x) {
        if (0<=x&&x<=9) return true;
        if (x<0||(x%10==0&&x!=0)) return false;
        int tmp=0;
        while (x>tmp){
            tmp=tmp*10+x%10;
            x/=10;
        }
        return tmp==x||tmp/10==x;
    }
}
