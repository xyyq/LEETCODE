package 双指针;

import java.util.ArrayList;
import java.util.List;

public class Solution438_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res=new ArrayList<>();
            int[] counts=new int[26];
            int pLength=p.length();
            int sLength=s.length();
        for(int i = 0; i < pLength; i++){
            counts[p.charAt(i) - 'a']++;
        }
            int left=0;
            int right=0;
            int[] tmpCount=new int[26];
            while (right<sLength){
                int curR=s.charAt(right)-'a';
                tmpCount[curR]++;
                while (tmpCount[curR]>counts[curR]){
                    tmpCount[s.charAt(left)-'a']--;
                    left++;
                }
                if (right-left+1==pLength){
                    res.add(left);
                }
                right++;
            }
            return res;
    }
}
