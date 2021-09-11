package 数组;

public class Solution1894_chalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int l = chalk.length ;
        int count = 0;
        if (l == 1){
            return 0;
        }
        while (k >= chalk[i%l]){
            k -= chalk[i%l];
            if (i < l){
                count += chalk[i];
            }else {
                k %= count;
            }
            i++;
        }
        return i % l;
    }
}
