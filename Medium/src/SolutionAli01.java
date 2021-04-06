import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SolutionAli01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (IsVa(nums[i])){
                count++;
            }else {
                int a1 = (int) Math.sqrt(nums[i]);
                int a2 = (int) Math.sqrt(nums[i])+1;
                int t = Math.min(nums[i]-a1*a1,a2*a2-nums[i]);
                pq.add(t);
            }
        }
        int remain = n/2 - count;
        int res = 0;
        while (remain > 0){
            res += pq.poll();
            remain--;
        }
        System.out.println(res);
    }
    public static boolean IsVa(int n){
        if ((int)Math.sqrt(n)*(int)Math.sqrt(n) == n){
            return true;
        }else {
            return false;
        }
    }
}
