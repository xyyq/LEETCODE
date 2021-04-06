package 字符串;

public class Solution925_isLongPressedName {
    public static void main(String[] args) {
        String name = "pyplrz", typed = "ppyypllr";

        System.out.println(new Solution925_isLongPressedName().isLongPressedName(name,typed));
    }
    public boolean isLongPressedName(String name, String typed) {
        if (name==null&&typed==null) return true;
        int m=name.length();
        int n=typed.length();
        if (m==0&&n==0) return true;
        int i = 0,k=0;
        for (; i <m&&k<n ; i++,k++) {
            int Ncount=0,Tcount=0;
            while (i<m-1&&name.charAt(i)==name.charAt(i+1)){
                Ncount++;
                i++;
            }
            while (k<n-1&&typed.charAt(k)==typed.charAt(k+1)){
                Tcount++;
                k++;
            }
            if (Tcount<Ncount||name.charAt(i)!=typed.charAt(k)) return false;
        }
        if (i!=m||k!=n) return false;
        return true;
    }
}
