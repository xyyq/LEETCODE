package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }

        backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;

    }
   static  Map<Character, String> phoneMap= Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public void backtrack(List<String> combinations,  String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,  digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
