import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SolutionBaidu01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        int[] sym = new int[10];
        Arrays.fill(sym,-1);
        sym[nums[0]] = 0;
        int[] dp = new  int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (sym[curr] != -1){
                if (sym[curr] < dp[i-1]){
                    dp[i] = dp[sym[curr]] + 1;

                }else {
                    dp[i] = dp[i-1]+1;
                    sym[curr] = dp[i];
                }
            }else {
                dp[i] = dp[i-1]+1;
                sym[curr] = dp[i];
            }
        }
        System.out.println(dp[n-1]);
    }
}
