package 两个字符串相乘;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution("12385678465", "456534353436842"));
    }
    public static String solution(String num1,String num2){
        int[] ansarr=new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0; i--) {
            int m=num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >=0; j--) {

                int n=num2.charAt(j)-'0';
                ansarr[i+j+1]+=m*n;
                ansarr[i+j]+=ansarr[i+j+1]/10;
                ansarr[i+j+1]=ansarr[i+j+1]%10;

            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i =ansarr[0]==0?1:0; i < ansarr.length; i++) {
            ans.append(ansarr[i]);
        }
        return ans.toString();
    }
}
