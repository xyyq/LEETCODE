package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

public class Solution842_splitIntoFibonacci {
    public static void main(String[] args) {
        String s="5511816597";
        System.out.println(new Solution842_splitIntoFibonacci().splitIntoFibonacci(s));
    }
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res=new ArrayList<>();
        dfs(res,0,S.toCharArray(),0);
        return res;
    }
    public boolean dfs(List<Integer> res,int pos,char[] s,int depth){
        if (pos==s.length&&depth>=3){
            return true;
        }
        for (int i = 1; pos+i <= s.length; i++) {
                if (s[pos]=='0'&&i>1){
                    break;
                }
                long num= toDigit(s,pos,pos+i);
                if (num>Integer.MAX_VALUE){
                    break;
                }
                if (depth>=2){
                    if (num>res.get(depth-1)+res.get(depth-2)){
                        break;
                    }
                }
                if (depth<=1||num==res.get(depth-1)+res.get(depth-2)){
                    res.add((int) num);
                    if (dfs(res,pos+i,s,depth+1)){
                        return true;
                    }
                    res.remove(res.size()-1);
                }
        }
        return false;
    }
    public long toDigit(char[] digit,int start,int end){
        long res=0;
        for (int i = start; i <end ; i++) {
            res=res*10+digit[i]-'0';
        }
        return res;
    }
}
