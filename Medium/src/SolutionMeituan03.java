import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionMeituan03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int C= sc.nextInt() ;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp < C){
                count++;
            } else if (tmp % C == 0) {
                count += tmp / C;
            } else {
                count += tmp / C + 1;
            }
        }

        int res = 0;

        res = count/m;
        if (count%m != 0){
            res++;
        }
        System.out.println(res);
    }



}
