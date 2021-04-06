package 数组;

import java.util.Arrays;
import java.util.Comparator;

public class Solution406_reconstructQueue {
    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(new Solution406_reconstructQueue().reconstructQueue(people)));


    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        int[][] res=new int[people.length][2];
        Arrays.fill(res,new int[]{-1});
        for (int i = 0; i < people.length; i++) {
            int pos=0;
            int k=people[i][1];
            int h=people[i][0];
            while (k!=0){
                if (res[pos][0]==-1||res[pos][0]>=h){
                    k--;
                }
                pos++;
            }
            for (int j = pos; j <people.length ; j++) {
                if (res[j][0]==-1){
                    res[j]=people[i];
                    break;
                }
            }
        }
        return res;
    }
}
