package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39_combinationSum {
    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        List<List<Integer>> res=new Solution39_combinationSum().combinationSum(nums,7);
        System.out.println(res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,res,new ArrayList<Integer>());
        return res;
    }
    public void dfs(int[] candidates,int target,int begin,List<List<Integer>> res, List<Integer> tmp){
        if(target==0){
            res.add(new LinkedList<>(tmp));
            return;
        }
        if(target<0) return;
        for (int i =begin ; i < candidates.length; i++) {
            if (candidates[i]<=target){
                int prev = candidates[i];
                tmp.add(prev);
                System.out.println("递归之前 => " + tmp + "，剩余 = " + (target - candidates[i]));
                dfs(candidates,target-candidates[i],i,res,tmp);
                tmp.remove(tmp.size()-1);
                System.out.println("递归之后 => " + tmp);
            }else {
               break;
            }
        }
    }























    List<List<Integer>> res;
    public List<List<Integer>> combinationSum01(int[] candidates, int target) {
        Arrays.sort(candidates);
         res = new ArrayList<>();
         dfs(candidates,new ArrayList<>(),res,target,target,0);
         return res;
    }
    public void dfs(int[] candidates,List<Integer> tmp,List<List<Integer>> res,int remain,int target,int begin){
        if (remain == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (remain < 0){
            return;
        }
        int n = candidates.length;
        for (int i = 0; i < n; i++) {
            if (remain < candidates[i]){
                return;
            }else {
                remain -= candidates[i];
                tmp.add(candidates[i]);
                dfs(candidates,tmp,res,remain,target,i);
                int x =tmp.get(tmp.size()-1);
                tmp.remove(tmp.size()-1);
                remain += x;
            }
        }
    }

}
