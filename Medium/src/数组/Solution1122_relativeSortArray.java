package 数组;

import java.util.*;

public class Solution1122_relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        List<Integer> list= new ArrayList<>();
        for (int x:arr1){
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1)||map.containsKey(o2)){
                    return map.getOrDefault(o1,1001)-map.getOrDefault(o2,1001);
                }
                return o1-o2;
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=list.get(i);
        }
        return arr1;
    }
}
