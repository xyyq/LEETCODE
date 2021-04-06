package 栈;

import java.util.Stack;

public class Solution150_evalRPN {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println( new Solution150_evalRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (isNumber(s)){
                stack.push(Integer.parseInt(s));
            }else {
                int a = stack.pop();
                int b = stack.pop();
                int t= cal(a,b,s);
                stack.push(t);
            }
        }
        return stack.pop();
    }
    public   int cal(int a, int b, String s){
        if (s.equals("+")){
            return a+b;
        }else if (s.equals("-")){
            return b-a;
        }else if (s.equals("*")){
            return a*b;
        }else {
            return b/a;
        }
    }
    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}