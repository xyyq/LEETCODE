package 数组;

public class Solution443_compress {
    public int compress(char[] chars) {
        int length = chars.length;
        char pre = chars[0];
        int right = 0;
        int curr = 1;
        if (length == 1){
            return 1;
        }
        for (int i = 1; i < length; i++) {
            if (chars[i] == pre){
                curr++;
            }else {
                chars[right++] = pre;
                pre = chars[i];
                if (curr != 1){
                    int l = getLength(curr);
                    for (int j = right + l - 1; j >= right; j--) {
                        chars[j] = (char) (curr % 10 + '0') ;
                        curr /= 10;
                    }
                    curr = 1;
                    right = right + l ;
                }
            }
        }
        chars[right++] = pre;
        if (curr != 1){
            int l = getLength(curr);
            for (int j = right + l - 1; j >= right; j--) {
                chars[j] = (char) (curr % 10 + '0') ;
                curr /= 10;
            }
            right = right + l;
        }
        return  right ;
    }

    private int getLength(int curr) {
        if (curr == 0){
            return 1;
        }
        int length = 0;
        while (curr > 0){
            curr /= 10;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution443_compress().compress(new char[]{'a','a','a','b','c','c','c'}));
    }
}
