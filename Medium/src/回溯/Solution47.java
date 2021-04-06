package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution47 {
    static int pre=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums={1,1,2};
        List<List<Integer>> res=new Solution47().permuteUnique(nums);
        System.out.println(res);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] vis=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res,0,nums,new ArrayList<>(),vis);
        return res;
    }
    public void backtrack(List<List<Integer>> res,int depth,int[] nums,List<Integer> temp,boolean[] visited){
        if (depth==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==pre&&i>0&&!visited[i-1]){
                continue;
            }
            if (!visited[i]){
                visited[i]=true;
                temp.add(nums[i]);
                backtrack(res,depth+1,nums,temp,visited);
                visited[i]=false;
                pre=nums[i];
                temp.remove(temp.size()-1);
            }
        }
    }
}
