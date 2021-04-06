package 数组;

public class Solution75_sortColors {
    public void sortColors(int[] nums) {
        int  n=nums.length;
        int p0=0,p2 = n-1;
        for (int i = 0; i <=p2; i++) {
            if (i<=p2&&nums[i]==2){
                nums[i]=nums[p2];
                nums[p2]=2;
                p2--;
            }
            if (i<=p2&&nums[i]==0){
                nums[i]=nums[p0];
                nums[p0]=0;
                p0++;
            }

        }

    }
    public void sortColors2(int[] nums){
        int  n=nums.length;
        int Zero=0;
        int Two=n-1;
        int i=0;
        while (i<=Two){
            if (nums[i]==0){
                nums[i]=nums[Zero];
                nums[Zero]=0;
                Zero++;
                i++;
            }else if (nums[i]==1){
                i++;
            }else {
                nums[i]=nums[Two];
                nums[Two]=2;
                Two--;
            }
        }
    }
}
