
import java.util.Arrays;
import java.util.Scanner;

public class SolutionMeituan02 {
    public static void main(String[] args)  {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                minA = Math.min(minA, tmp);
        }
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            minB = Math.min(minB, tmp);
        }
        int res;
        if (minA > minB){
            res = m+minB-minA;
        }else {
            res = minB - minA;
        }
        System.out.println( res);
    }
}
