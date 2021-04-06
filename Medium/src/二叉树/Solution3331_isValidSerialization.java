package 二叉树;

public class Solution3331_isValidSerialization {
    public boolean isValidSerialization(String preorder) {
        int i = 0;
        int n = preorder.length();
        int flag = 1;
        if (preorder.charAt(0) == '#'){
            return n == 1;
        }
        while (i < n){
            if (flag == 0){
                return false;
            }
            if (preorder.charAt(i) == ','){
                i++;
            }else if (preorder.charAt(i) == '#'){
                flag--;
                i++;
            }else {
                while (i<n && preorder.charAt(i) != ','){
                    i++;
                }
                flag++;
            }
        }
        return flag == 0;
    }
}
