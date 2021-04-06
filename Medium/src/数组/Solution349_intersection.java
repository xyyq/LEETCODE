package 数组;

import java.util.HashSet;
import java.util.Set;

public class Solution349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int x:nums1){
            set1.add(x);
        }
        for(int x:nums2){
            set2.add(x);
        }
        
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num:set1){
            if (set2.contains(num)){
                intersectionSet.add(num);
            }
        }
        int[] res=new int[intersectionSet.size()];
        int index=0;
        for (int num:intersectionSet){
            res[index++]=num;
        }
        return res;
    }
}
