package 哈希;

import java.util.HashMap;

public class Solution290_wordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length!=pattern.length()){
            return false;
        }
        HashMap<Character, String> ch2str = new HashMap<>();
        HashMap<String, Character> str2ch = new HashMap<>();
        for (int i = 0; i <strings.length ; i++) {
            char c = pattern.charAt(i);
            if (ch2str.containsKey(c)){
                if (!ch2str.get(c).equals(strings[i])){
                    return false;
                }
            }else {
                if (str2ch.containsKey(strings[i])){
                    return false;
                }
                ch2str.put(c,strings[i]);
                str2ch.put(strings[i],c);
            }
        }
        return true;
    }

}
