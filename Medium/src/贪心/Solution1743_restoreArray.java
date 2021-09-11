package 贪心;

import java.util.*;

public class Solution1743_restoreArray {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{91207,59631},{581,91207},{51465,20358},{-66119,94118},{-7392,72809},{51465,-7392},
        {-98504,-29411},{-98504,35968},{35968,59631},{94118,20358},{72809,581},{34348,43653},{43653,-29411}};
        System.out.println(Arrays.toString(new Solution1743_restoreArray().restoreArray(nums)));

    }
    public int [] restoreArray(int[][] adjacentPairs) {
        int size = adjacentPairs.length;
        int[] res = new int[size + 1];
        Map<Integer,Union> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                if (!map.containsKey(adjacentPairs[i][j])){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(adjacentPairs[i][(j+1) % 2]);
                    map.put(adjacentPairs[i][j],new Union(1, tmp));
                }else {
                    map.get(adjacentPairs[i][j]).add(adjacentPairs[i][(j+1) % 2]);
                }
            }
        }
        Set<Integer> set = map.keySet();
        int head = 0;
        for (Integer i : set){
            if (map.get(i).getSize() % 2 == 1){
                res[head] = i;
                head = size;
            }
        }
        int last = res[0];
        for (int i = 1; i < size ; i++) {
            int currValue = map.get(last).next();
            map.get(currValue).delete(last);
            res[i] = currValue;
            last = currValue;
        }
        return res;
    }
}
class Union{
    private int size;
    private ArrayList<Integer> list;
    public ArrayList<Integer> getList() {
        return list;
    }
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    public Union(int size, ArrayList list){
        this.size = size;
        this.list = list;
    }
    public void add(Integer integer){
        list.add(integer);
         size++;
         return;
    }
    public int getSize(){
        return size;
    }
    public void  delete(Integer integer){
        size--;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(integer)){
                list.remove(integer);
                break;
            }
        }
        return;
    }
    public int next(){
        int i = list.iterator().next();
        size--;
        list.remove(0);
        return i;
    }

}
