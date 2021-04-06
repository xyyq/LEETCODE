package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo {
    public static int[][] digits={{1,2},{4,5,6},{7,8,9}};
    public static List<String> combinations=new ArrayList<>();
    public static void main(String[] args) {
       /*  String s="";
         dfs(s,0);
        System.out.println(combinations);*/
        backtrack(combinations,digits,0,new Stack<Integer>());
        System.out.println(combinations);
        List<String> combinations1=new ArrayList<>();
        dfs(combinations1,digits,0,"");
        System.out.println(combinations1);
    }
    public static void backtrack(List<String> combinations, int[][] digits, int index, Stack<Integer> stack){
        if (digits.length==index){
            combinations.add(stack.toString());
            return;
        }else {
            for (int i = 0; i < digits[index].length; i++) {
                stack.push(digits[index][i]);

                backtrack(combinations,digits,index+1,stack);
                //回溯保存了中间变量 上一次的stack被改变了 需要还原所有要回退一次操作
                stack.pop();
            }
        }
    }
    public static void dfs(List<String> combinations, int[][] digits, int index, String s){
        if (index==digits.length){
            combinations.add(s);
        }else {
            for (int i = 0; i < digits[index].length; i++) {
                dfs(combinations,digits,index+1,s+digits[index][i]);
                //深度搜索 上一次递归的s没有改变
            }
        }
    }
    public static void bfs(List<String> combinations, int[][] digits, int index, Stack<Integer> stack){

    }
    public static void dfs(String s,int i){
        if (i==digits.length){
            combinations.add(s);
            return;
        }else {
            for (int j = 0; j < digits[i].length; j++) {
                dfs(s+digits[i][j],i+1);
            }
        }
    }
}
