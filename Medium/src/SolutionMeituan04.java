import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SolutionMeituan04 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        if (m < 3){
            System.out.println(m);
        }
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[] ints =new int[n*n-n];
        m = m - 2;
        int yesterday= 2;
        int  theDayBefore= 1;
        int  day = 3;
        int t = 0;
        while (day < m && day < n*n-n ) {
            int today = nums[yesterday][theDayBefore];
            ints[t++] =today;
            theDayBefore = yesterday;
            yesterday =today;
            day++;
        }
            System.out.println(ints[t-3]);



    }

}
