package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution316_removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        HashSet<Character> sets=new HashSet<>();
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);

        int[] counts =new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (!sets.contains(c)){
                while (!stack.isEmpty()&&c<stack.peek()&&last_occurrence.get(stack.peek())>i){
                    sets.remove(stack.peek());
                    stack.pop();
                }
                sets.add(c);
                stack.push(c);
            }
        }
        StringBuffer sb=new StringBuffer();
        for (Character c:stack){
            sb.append(c.charValue());
        }
        return sb.toString();
    }
}
