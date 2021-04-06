package 数组;

import java.util.ArrayList;
import java.util.List;

public class Solution49_groupAnagrams {
    public static void main(String[] args) {
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution49_groupAnagrams().groupAnagrams(strings));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res=new ArrayList<>();
            for (String str:strs){
                boolean find=false;
                for (List<String> list:res){
                    if (isGroup(list.get(0),str)){
                        list.add(str);
                        find=true;
                        break;
                    }
                }
                if (!find){
                    List<String> list1=new ArrayList<>();
                    list1.add(str);
                    res.add(list1);
                }
            }
            return res;
    }
    public boolean isGroup(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        int[] ints=new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ints[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c=s2.charAt(i);
            ints[c-'a']--;
            if (ints[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
