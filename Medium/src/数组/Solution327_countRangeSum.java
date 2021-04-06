package 数组;

public class Solution327_countRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }

        return count(sum,0,sum.length-1,lower,upper);
    }
    public int count(long[] sum,int left,int right,int lower,int upper){
        if (left==right){
          return 0;
        }

        int mid=(left+right)/2;
        int n1=count(sum,left,mid,lower,upper);
        int n2=count(sum,mid+1,right,lower,upper);
        int res=n1+n2;
        int i=left,l=mid+1;
        while (i<=mid){
            while (l <= right &&sum[l]<sum[i]+lower){
                l++;
            }
            int r=l;
            while (r <= right && sum[r]<=sum[i]+upper){
                r++;
            }
            res+=r-l;
            i++;
        }
        int[] sorted=new int[right-left+1];
        int p1=left,p2=mid+1;
        int p=0;
        while (p1<=mid||p2<=right){
            if (p1>mid){
                sorted[p++]=(int) sum[p2++];
            }else if (p2>right){
                sorted[p++]=(int) sum[p1++];
            }else {
                if (sum[p1]<=sum[p2]){
                    sorted[p++]=(int) sum[p1++];
                }else {
                    sorted[p++]=(int) sum[p2++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            sum[j+left]=sorted[j];
        }
        return res;
    }
}
