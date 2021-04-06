package 广度优先搜索;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution210_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges =new ArrayList<>();
        int[] indeg=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints:prerequisites){
            edges.get(ints[1]).add(ints[0]);
            indeg[ints[0]]++;
        }
        Deque<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.add(i);
            }
        }
        int[] res=new int[numCourses];
        int count=0;
        while (!queue.isEmpty()){
            int tmp=queue.poll();
            res[count]=tmp;
            count++;
            for (int x:edges.get(tmp)){
                indeg[x]--;
                if (indeg[x]==0){
                    queue.offer(x);
                }
            }
        }
        if (count!=numCourses) return new int[0];
        return res;
    }
}
