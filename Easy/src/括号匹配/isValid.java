package 括号匹配;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String s = "[{]}()";

        System.out.println(is(s));
    }
static String[] ss1={"[]","{}","()"};

    public static boolean is(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if ((s1.equals("[")) || (s1 .equals("("))||s1.equals("{")) {
                stack.push(s1);
            } else {
                if (!stack.isEmpty()) {
                    String ss = stack.pop();
                    int j=0;
                    for ( ; j < 3; j++) {
                        if (ss1[j].contains(ss) && ss1[j].contains(s1)) {
                            break;
                        }
                    }
                    if (j==3){
                        return false;
                    }


                }else {
                    return false;
                }
            }
        }
           return stack.isEmpty();
        }
}