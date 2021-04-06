package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118_generate {
    public static void main(String[] args) {
        System.out.println(new Solution118_generate().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        int[] prev=new int[numRows];
        int[] curr=new int[numRows];

        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            curr[0]=1;curr[i]=1;
            for (int j = 1; j < i; j++) {
                curr[j]=prev[j]+prev[j-1];
            }
            List<Integer> tmp=new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                tmp.add(curr[j]);
            }
            res.add(tmp);
            prev= Arrays.copyOf(curr,i+1);
        }
        return res;
    }
}
