package 数组;

import java.util.ArrayList;
import java.util.List;

public class Solution68_fullJustify {

    List<String> res = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        int size = words.length;
        boolean isFinal = false;

        int first = 0, last = 0;
        int currLength = 0;
        while (first < size){
            StringBuilder stringBuilder = new StringBuilder();
            while ( last < size && currLength + words[last].length() + (first == last ? 0 : 1) <= maxWidth ){
                currLength += words[last].length() + (first == last ? 0 : 1);
                last++;
            }
            if (last == size && currLength <= maxWidth){
                addWordsToListFinal(first, last - 1, words, maxWidth,stringBuilder);
            }else {
                addWordsToList(first, last - 1, words, maxWidth,stringBuilder,currLength);
            }
            first = last;
            currLength = 0;
        }
        return res;
    }

    private void addWordsToListFinal(int first, int last, String[] words, int maxWidth, StringBuilder stringBuilder) {

        int tmp = maxWidth;
        int interval = 1;
        for (int i = first; i < last; i++) {
            stringBuilder.append(words[i]);
            stringBuilder.append(getBlank(interval));
            tmp -= words[i].length() + 1;
        }
        stringBuilder.append(words[last]);
        tmp -= words[last].length();
        stringBuilder.append(getBlank(tmp));
        res.add(stringBuilder.toString());
    }

    private void addWordsToList(int first, int last, String[] words, int maxWidth, StringBuilder stringBuilder, int currLength) {
        int wordLength = currLength - (last - first);

        int tmp,interval ;
        if (last != first){
            tmp = (maxWidth - wordLength) % (last - first) ;
            interval = (maxWidth - wordLength) / (last - first);
        }else {
            tmp = maxWidth - wordLength;
            interval = 0;
        }

        for (int i = first; i < last; i++) {
            stringBuilder.append(words[i]);
            stringBuilder.append(getBlank(interval + (tmp > 0 ? 1 :0)));
            tmp--;
        }
        stringBuilder.append(words[last]);
        stringBuilder.append(getBlank(tmp));
        res.add(stringBuilder.toString());
    }

    private String getBlank(int i) {
        StringBuilder s = new StringBuilder();
        while (i > 0){
            s.append(" ");
            i--;
        }
        return s.toString();
    }
    public static void main(String[] args) {
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> strings = new Solution68_fullJustify().fullJustify(words, 20);
        System.out.println(strings);
    }
}
