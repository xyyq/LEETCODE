package 数组;

public class Solution1006_clumsy {
    public int clumsy(int N) {
        int res = 0;
        boolean flag = true;
        if (N < 4){
            return thrTwo(N);
        }
        while (N >= 4){
            if (flag){
                res += four(N) + 2*(N-3);
                N -= 4;
                flag =false;
            }else {
                res -= four(N);
                N -= 4;
            }
        }
        if (N == 0){
            return res;
        }else {
            return res-thrTwo(N);
        }
    }
    public int four(int m){
        return m*(m-1)/(m-2)-(m-3);
    }
    public int thrTwo(int m){
        int res = 1;
        for (int i = 1; i <= m; i++) {
            res *= i;
        }
        return res;
    }
}
