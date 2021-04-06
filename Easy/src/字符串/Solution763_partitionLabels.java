package 字符串;

import java.util.ArrayList;
import java.util.List;

public class Solution763_partitionLabels {
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        System.out.println(new Solution763_partitionLabels().partitionLabels(s));
    }
    public List<Integer> partitionLabels(String S) {

            int start=0,end=0;

            List<Integer> res=new ArrayList<>();
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
            while (start<length){
                    end=last[S.charAt(start) - 'a'];
                    for (int i = start; i <end; i++) {
                      end=Math.max(end,last[S.charAt(i) - 'a']);
                    }
                    res.add(end-start+1);
                    start=end+1;
            }
            return res;
    }

}
