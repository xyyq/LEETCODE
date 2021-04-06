package 数组;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973_kClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        int n=points.length;
        for (int i = 0; i < K; i++) {
            pq.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});
        }
        for (int i = K; i <n ; i++) {
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if (dist<pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }
        int res[][]=new  int[K][2];
        for (int i = 0; i < K; i++) {
            res[i]=points[pq.poll()[1]];
        }
        return  res;
    }
}
