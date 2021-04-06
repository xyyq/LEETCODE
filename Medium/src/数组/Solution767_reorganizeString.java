package 数组;

public class Solution767_reorganizeString {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] count=new int[26];

        int max=0;
        for (int i = 0; i < S.length(); i++) {
            char c=S.charAt(i);
            count[c-'a']++;
            max=Math.max(max,count[c-'a']);
        }
        if (max>(S.length()+1)/2){
            return "";
        }
        char[] res=new char[S.length()];
        int even=0,odd=1;
        int halfLength = S.length()/2;
        for (int i = 0; i < 26; i++) {
            char c=(char) (i+'a');
            while (count[i]>0&&count[i]<=halfLength&&odd<S.length()){
                res[odd]=c;
                odd+=2;
                count[i]--;
            }
            while (count[i]>0&&even<S.length()){
                res[even]=c;
                even+=2;
                count[i]--;
            }
        }
        return new String(res);
    }
}
