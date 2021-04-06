package 栈;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402_removeKdigits {
    public String removeKdigits(String num, int k) {
        if (k==0) return num;
        Deque<Character> deque =new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (!deque.isEmpty()&&k>0&& deque.peekLast()>num.charAt(i)){
              deque.pollLast();
              k--;
            }
            deque.offerLast(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

}
