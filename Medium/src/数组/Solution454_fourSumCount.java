package 数组;

import java.util.Arrays;
import java.util.HashMap;

public class Solution454_fourSumCount {
    public static void main(String[] args) {
        int[] A={-1,-1};
        int[] B={-1,1};
        int[] C={-1,1};
        int[] D={1,-1};
        System.out.println(new Solution454_fourSumCount().fourSumCount(A,B,C,D));
    }
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int n=A.length;
        int res=0;
        int[] target=new int[n*n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
               target[i*n+j]=(A[i]+B[j]);
            }
        }
        Arrays.sort(target);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum=-(C[i]+D[j]);

                int left=binaryLeftSearch(target,sum);
                if (left!=-1){
                    res+=binaryRightSearch(target,sum)-left+1;
                }
            }
        }
        return res;
    }
    public int binaryLeftSearch(int[] nums,int target){//左边界
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<r){
            mid=(l+r)/2;
            if (nums[mid]==target){
                r=mid;
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return nums[l]==target?l:-1;
    }
    public int binaryRightSearch(int[] nums,int target){//右边界
        int l=0;
        int r=nums.length-1;
        int mid;
        while (l<r){
            mid=(l+r+1)/2;
            if (nums[mid]==target){
                l=mid;
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return nums[r]==target?r:-1;
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer,Integer> sumAB =new HashMap<>();
        for(int a:A){
            for(int b:B){
                sumAB.put(a+b, sumAB.getOrDefault(a+b,0)+1);
            }
        }
        int res=0;
        for (int c:C){
            for (int d:D){
                if (sumAB.containsKey(-c-d)){
                    res+=sumAB.get(-c-d);
                }
            }
        }
        return res;
    }
}
