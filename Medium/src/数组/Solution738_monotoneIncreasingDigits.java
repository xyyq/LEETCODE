package 数组;

public class Solution738_monotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(new Solution738_monotoneIncreasingDigits().monotoneIncreasingDigits(123499921));
    }
    public int monotoneIncreasingDigits(int N) {
       char[] chars = Integer.toString(N).toCharArray();
       int n=chars.length;
       int tmp=-1;
        for (int i = 0; i <n-1 ; i++) {
            if (chars[i]>chars[i+1]){
                if (tmp!=-1&&chars[i]==chars[tmp]){
                    i=tmp;
                }
                chars[i]--;
                for (int j = i+1; j < n; j++) {
                    chars[j]='9';
                }
                break;
            } else if (chars[i]==chars[i+1]){
                if (tmp==-1||chars[i+1]!=chars[tmp]){
                    tmp=i;
                }else {
                   continue;
                }

            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res=res*10+chars[i]-'0';
        }
        return res;
    }
}
