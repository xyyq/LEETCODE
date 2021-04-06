package 双指针;

import java.util.Arrays;

public class Solution242_isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] sCounts =new   int[26];
        for (int i = 0; i < s.length(); i++) {
            sCounts[s.charAt(i)-'a']++;
        }
        int[] tCounts=new int[26];
        for (int i = 0; i < t.length(); i++) {
            int curr=t.charAt(i)-'a';
            tCounts[curr]++;
            if (tCounts[curr]>sCounts[curr]){
                return false;
            }
        }
        return true;
    }
}
