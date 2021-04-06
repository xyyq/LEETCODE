package 栈;

import java.util.ArrayList;
import java.util.Stack;


public class Solution227_calculate {
    public static void main(String[] args) {
        String s = " 3-15 / 2 ";
        System.out.println(new Solution227_calculate().calculate(s));
    }
    public int calculate(String s) {
        
        int res = 0;
        int n = s.length();
        int i = 0;
        Stack<Integer> NumStack = new Stack<>();
        Stack<Character> ChStack = new Stack<>();
        while (i < n){
            if (s.charAt(i) == ' '){
                i++;
                continue;

            }else if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                while (!ChStack.empty() && compare(ChStack.peek(), s.charAt(i))){
                    res = Cau(NumStack.pop(), NumStack.pop(), ChStack.pop());
                    NumStack.push(res);
                }
                ChStack.push(s.charAt(i));
                i++;
            }else {
                int num = 0;
                while (i < n && s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
               NumStack.push(num);
            }
        }
        while (!ChStack.empty()){
            res = Cau(NumStack.pop(), NumStack.pop(), ChStack.pop());
            NumStack.push(res);
        }
        return  NumStack.peek();
    }
    public boolean compare(char s1, char s2){
        ArrayList<Character> Plus = new ArrayList<>();
        Plus.add('+');
        Plus.add('-');
        ArrayList<Character> Multi = new ArrayList<>();
        Multi.add('*');
        Multi.add('/');
        if (Plus.contains(s1) && Multi.contains(s2)){
            return false;
        }
        return true;
    }
    public int Cau(int a, int b, char s){
        if (s == '+'){
            return a + b;
        }else if (s == '-'){
            return b - a;
        }else if (s == '*'){
            return a * b;
        }else {
            return b / a;
        }
    }
}
