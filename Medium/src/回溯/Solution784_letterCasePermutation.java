package 回溯;

import java.util.ArrayList;
import java.util.List;

public class Solution784_letterCasePermutation {
    public static void main(String[] args) {
        String S = "a1b2";
        System.out.println(new Solution784_letterCasePermutation().letterCasePermutation(S));
    }
    public List<String> letterCasePermutation(String S) {
        List<String> res=new ArrayList<>();
        char[] chars=S.toCharArray();
        dfs(res,chars,S.length(),0);
        return res;
    }
    public void dfs(List<String> res,char[] tmp,int length,int curr){
        if (curr==length){
            res.add(new String(tmp));
            return;
        }
        if (Character.isAlphabetic(tmp[curr])){
            if (Character.isLowerCase(tmp[curr])){
                tmp[curr]-=32;
                dfs(res,tmp,length,curr+1);
                tmp[curr]+=32;
            }else {
                tmp[curr]+=32;
                dfs(res,tmp,length,curr+1);
                tmp[curr]-=32;
            }
        }
        dfs(res,tmp,length,curr+1);
    }
}
