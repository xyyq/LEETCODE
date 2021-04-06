import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SolutionAli {
    public static void main(String[] args)  throws IOException {
     /*   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[][] nums = new int[n][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0){
                    nums[j][i] = Integer.parseInt(s1[j]);
                }else {
                    nums[j][i] = Integer.parseInt(s2[j]);
                }
            }
        }*/
        int n;
        Scanner sc = new Scanner(  System.in);

        Random rand = new Random();
        int count = 0;
        for (int i = 3; i < 3000; i++) {
            int[][] MyNums = new int[i][i];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < i; k++) {
                    MyNums[k][j] = rand.nextInt(10000);
                }
            }
            int a = solution01(i, MyNums);
            int b = solution(i, MyNums);
            if (a != b){
                System.out.println("a=="+ a +";"+"b=="+b);
            }else {
                System.out.println("第"+count+"次相等"+ (i-3));
                count++;
            }
        }



    }
    public static int solution(int n, int[][] nums){
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = nums[i][0];
            for (int j = i+1; j < n; j++) {
                int b = nums[j][0];
                if (a < b){
                    for (int k = j+1; k < n; k++) {
                        int c = nums[k][0];
                        if (b < c){
                            res = Math.min(res, nums[i][1]+nums[j][1]+nums[k][1]);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
      public static int solution01(int n, int[][] nums){
          int res = Integer.MAX_VALUE;
          int[] dp02 = new int[n];
          Arrays.fill(dp02, Integer.MAX_VALUE);
          for (int j = 1; j < n; j++) {
              for (int i = 0; i < j; i++) {
                  if (nums[j][0] > nums[i][0]){
                      dp02[j] = Math.min(dp02[j], nums[j][1] + nums[i][1]);
                  }
              }
          }
          for (int k = 2; k < n; k++) {
              for (int j = 1; j < k; j++) {
                  if (nums[k][0] > nums[j][0] && dp02[j] != Integer.MAX_VALUE){
                      res = Math.min(dp02[j] + nums[k][1], res );
                  }
              }
          }
          return res == Integer.MAX_VALUE ? -1 : res;
      }

}
