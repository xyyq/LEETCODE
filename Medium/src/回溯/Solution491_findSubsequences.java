package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution491_findSubsequences {
    public static void main(String[] args) {
        int[] nums={4,7,6,7};
        System.out.println(new Solution491_findSubsequences().findSubsequences(nums));
    }
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        traceBack(res,new ArrayList<>(),nums,0,Integer.MIN_VALUE);
        return res;
    }
    public void traceBack(List<List<Integer>> res,List<Integer> tmp,int[] nums,int curr,int last){
        if (curr==nums.length){
                if (tmp.size()>=2){
                    res.add(new ArrayList<Integer>(tmp));
                }
            return;
        }
        //{4,7,6,7} 每个元素对应两种选择 选或不选 对于相同的元素选了前面 后面只有选一种操作 即对于相同元素 同一层只保留最后一个(4 ,7.0-1,7.1-1)(4,7.0-0,7.1-1)
                                                                            //(4,7,7) ( 4,7)
        if (nums[curr]>=last){
            tmp.add(nums[curr]);
            traceBack(res,tmp,nums,curr+1,nums[curr]);
            tmp.remove(tmp.size()-1);
        }
        if (nums[curr]!=last){
            traceBack(res, tmp, nums, curr+1, last);
        }
    }
}
