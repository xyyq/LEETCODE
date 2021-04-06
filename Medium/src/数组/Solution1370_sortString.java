package 数组;

public class Solution1370_sortString {
    public String sortString(String s) {
        int[] counts=new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        StringBuffer res=new StringBuffer();
        while (res.length()<s.length()){
            for (int i = 0; i < 26; i++) {
                if (counts[i]>0){
                    res.append((char)i+'a');
                    counts[i]--;
                }
            }
            for (int i = 25; i >=0 ; i--) {
                if (counts[i]>0){
                    res.append((char)i+'a');
                    counts[i]--;
                }
            }
        }
        return res.toString();
    }
}
