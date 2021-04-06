import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1002 {
    public static void main(String[] args) {
        String[] strings={"abddbaba","bacbcbcb"};
        System.out.println(new Solution1002().commonChars(strings));
    }
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();
        if(A.length==0){
            return res;
        }
        int[] min=new int[26];
        for(int i=0;i<A[0].length();++i){
            min[A[0].charAt(i)-'a']++;
        }
        for(int i=1;i<A.length;++i){
            int[] tmp = new int[26];
            for(int j=0;j<A[0].length();++j){
                tmp[A[i].charAt(j)-'a']++;
            }
            for(int k=0;k<26;++k){
                min[k]=Math.min(min[k],tmp[k]);
            }
        }
        for(int i=1;i<26;++i){
            for(int j=0;j<min[i];++j){
                res.add(String.valueOf((char)(i+'a')));
            }
        }
        return res;
    }
}
