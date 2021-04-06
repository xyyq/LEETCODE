package 广度优先搜索;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution207_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges= new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for (int[] x:prerequisites){
            edges.get(x[1]).add(x[0]);
            indeg[x[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.add(i);
            }
        }
        int visited =0;
        while (!queue.isEmpty()){
            ++visited;
            int tmp=queue.poll();
            for(int v:edges.get(tmp)){
                indeg[v]--;
                if (indeg[v]==0){
                    queue.add(v);
                }
            }
        }
        return visited==numCourses;
    }
}
