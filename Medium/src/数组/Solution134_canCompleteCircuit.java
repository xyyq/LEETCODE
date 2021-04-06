package 数组;

public class Solution134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int  len=gas.length;
        int spare=0,res=0;
        int min=Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            spare=gas[i]-cost[i];
            if (spare<min){
                min=spare;
                res=i;
            }
        }
        return  spare>=0?(res+1):-1;
    }
}
