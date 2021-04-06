package 栈;

import java.util.Stack;

public class Solution394_decodeString {
    public static void main(String[] args) {
        String s="3[a]2[bc]";
        System.out.println(new Solution394_decodeString().decodeString(s));
    }
    public String decodeString(String s) {
        Stack<Integer> numsStack=new Stack<>();
        Stack<StringBuffer> ansStack=new Stack<>();
        StringBuffer ans=new StringBuffer();
        int multi=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)){
                multi=multi*10+c-'0';
            }else if (c=='['){
                ansStack.push(ans);
                numsStack.push(multi);
                ans=new StringBuffer();
                multi=0;
            }else if (Character.isAlphabetic(c)){
                ans.append(c);
            }else {
                StringBuffer tmp=ansStack.pop();
                int times=numsStack.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(ans);
                }
                ans=tmp;
            }

        }
        return ans.toString();
    }
}
