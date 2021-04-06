import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionMeituan01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1= br.readLine();
        String s2= br.readLine();
        int res  = 0;
        int[] table = new int[26];
        for(int i = 0; i < s1.length();i++){
            table[s1.charAt(i)-'a'] = i;
        }
        char c= s2.charAt(0);
        res += table[c-'a'];
        int prev = table[c-'a'];
        for(int i = 1; i < s2.length();i++){
            c= s2.charAt(i);
            int point = table[c-'a'];
            if(point > prev){
                res += point - prev - 1;
                prev = point;
            }else{
                res += 25 - prev + point;
                prev = point;
            }
        }
        System.out.println(res);
    }

}
