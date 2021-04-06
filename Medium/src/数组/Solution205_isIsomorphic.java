package 数组;

import java.util.HashMap;
import java.util.HashSet;

public class Solution205_isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!hm.containsKey(c1)){
                if (set.contains(c2)){
                    return false;
                }
                hm.put(c1, c2);
                set.add(c2);
            }else {
                if (hm.get(c1) != c2) {
                    return false;
                }
            }
        }
        return true;
    }
}
