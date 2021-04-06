package 回溯;

import java.util.ArrayList;
import java.util.List;

public class Solution78_subsets {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Solution78_subsets().subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        traceback(nums,new ArrayList<>(),res,0);
        return res;
    }
    public void traceback(int[] nums,List<Integer> tmp,List<List<Integer>> res,int curr){
        res.add(new ArrayList<>(tmp));
        for (int i = curr; i < nums.length; i++) {
            tmp.add(nums[i]);
            traceback(nums,tmp,res,i+1);
            tmp.remove(tmp.size()-1);
        }

    }
}
