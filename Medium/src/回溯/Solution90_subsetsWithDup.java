package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res=new ArrayList<>();
        traceback(res,new ArrayList<>(),nums,0);
        return res;
    }
    List<List<Integer>> res;
    public void traceback(List<List<Integer>> res,List<Integer> tmp,int[] nums,int curr){

        res.add(new ArrayList<>(tmp));
        for (int i = curr; i < nums.length; i++) {
            if (curr<i&&nums[i]==nums[i-1]){
                continue;
            }
            /*              {}(1,2,2,2)
              {1} (2) (2)(2) // 再再退 再跳过                             {2} (2)(2)
             {1,2} (2) (2)  再退 可选的第二个元素与前面的元素相同 跳过再退
            {1,2,2} (2)  退到这里 只有一个元素可选
            {1,2,2,2} ()
            */
            tmp.add(nums[i]);
            traceback(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public void traceback1(List<List<Integer>> res,List<Integer> tmp,int[] nums,int curr,int last){
        if (curr==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[curr]);
        traceback1(res, tmp, nums, curr+1,nums[curr]);
        tmp.remove(tmp.size()-1);
        if (nums[curr]!=last){
            traceback1(res, tmp, nums, curr+1,last);
        }
    }






























    public void dfs(int[] nums, int begin, ArrayList<Integer> tmp){
        if (begin == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i-1]){
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
