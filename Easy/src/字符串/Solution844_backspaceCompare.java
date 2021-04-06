package 字符串;

import java.util.Stack;

public class Solution844_backspaceCompare {
    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(new Solution844_backspaceCompare().backspaceCompareDouble(S, T));
    }
    public boolean backspaceCompare(String S, String T) {
        if (S.length()==0&&T.length()==0) return true;
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='#'&&!s1.empty()){
                s1.pop();
            }
            if (S.charAt(i)!='#'){
                s1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i)=='#'&&!s2.empty()){
                s2.pop();
            }
            if (T.charAt(i)!='#'){
                s2.push(T.charAt(i));
            }
        }
        return s1.equals(s2);
    }
    public boolean backspaceCompareDouble(String S, String T){
        int i = S.length()-1;
        int j = T.length()-1;
        int skipS=0,skipT=0;
        while (i>=0||j>=0){
            while (i>=0){
                if (S.charAt(i)=='#'){
                    skipS++;
                    i--;
                }else if (skipS>0){
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }
            while (j>=0){
                if (T.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if (skipT>0){
                    skipT--;
                    j--;
                }else {
                    break;
                }
            }
            if (i>=0&&j>=0){
                if (T.charAt(j)!=S.charAt(i)){
                    return false;
                }else {
                    i--;
                    j--;
                }
            }else if (i>=0||j>=0){
                return false;
            }
        }
        return true;
    }
}
