package 数组;

public class Solution389_findTheDifference {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
        for (int i = 0; i < s.length(); i++) {
            sumS+=s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sumT+=t.charAt(i);
        }
        return (char) (sumT - sumS);
    }
}
