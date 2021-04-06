package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40_combinationSum2 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        System.out.println(new Solution40_combinationSum2().combinationSum2(nums,8));
    }
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0,new ArrayList<>(),candidates,target);
        return res;
    }
    public void backTrack(int begin, List<Integer> tmp, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0) return;
        for (int i = begin; i < candidates.length; i++) {
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            if (target >= candidates[i]) {
                tmp.add(candidates[i]);
                backTrack(i + 1, tmp, candidates, target - candidates[i]);
                tmp.remove(tmp.size() - 1);
            } else {
                return;
            }
        }
    }





















    public List<List<Integer>> combinationSum2v2(int[] candidates, int target){
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int[] candidates, int target, ArrayList<Integer> tmp,int begin){
        if (target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0){
            return;
        }
        int n = candidates.length;
        for (int i = begin; i < n; i++) {
            if (target < candidates[i]){
                return;
            }
            tmp.add(candidates[i]);
            dfs(candidates,target-candidates[i],tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }









}
