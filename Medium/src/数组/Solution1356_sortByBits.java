package 数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1356_sortByBits {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        if(n==1) return arr;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (count(x) !=count(y)) {
                    return count(x) - count(y);
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public int count(int x){
        int res=0;
        while(x!=0){
            res+=x%2;
            x/=2;
        }
        return res;
    }
}
