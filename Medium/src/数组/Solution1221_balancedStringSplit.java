package 数组;

public class Solution1221_balancedStringSplit {
    public int balancedStringSplit(String s) {
        int res = 0;
        int size = s.length();
        int rNum = 0, lNum = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'R'){
                rNum++;
            }else {
                lNum++;
            }
            if (lNum == rNum && lNum > 0){
                res += 1;
                lNum = rNum = 0;
            }
        }
        if (lNum != 0){
            res += 1;
        }
        return res;
    }
}
