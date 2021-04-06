package 栈;

import java.util.Stack;

public class Solution1047_removeDuplicates {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (char c : chars){
           if (top >= 0 && c == stack.charAt(top)){
               stack.deleteCharAt(top);
               top--;
           }else {
               stack.append(c);
               top++;
           }
        }
        return stack.toString();
    }
}
