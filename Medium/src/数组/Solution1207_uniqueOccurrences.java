package 数组;

import java.util.HashSet;
import java.util.Set;

public class Solution1207_uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[1000 + arr[i]]++;
        }
        Set<Integer> set=new HashSet<>();
        for(int x:count){
            if (x==0) continue;
            if (!set.add(x)) return false;
        }
        return  true;
    }
}
