package 回溯;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  res=new ArrayList<>();
      /*  String[][] visited=new String[n][n];
        backtrack(res,new ArrayList<>(),visited,n,0);*/
        dfs(res,n,0,new int[n]);
        return res;
    }
    public void backtrack(List<List<String>> res,List<String> temp,String[][] visited,int n,int depth){
        if (depth==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (contain(visited,depth,i)){
                visited[depth][i]="Q";
                String s=new String();
                for (int j = 0; j <n ; j++) {
                    if (j==i){
                        s+="Q";
                    }else {
                         s+=".";
                    }
                }
                temp.add(s);
                backtrack(res,temp,visited,n,depth+1);
                visited[depth][i]="";
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean contain(String[][] strings,int column,int line){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (i==column||j==line||(i-j)==(column-line)||(i+j)==(column+line)){
                    if (strings[i][j]=="Q") return false;
                }
            }
        }
        return true;
    }
    public void dfs(List<List<String>> res,int n,int depth,int[] pos){
        if (depth==n){
            List<String> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    sb.append(k == pos[j] ? "Q" : ".");
                }
                t.add(sb.toString());
            }
            res.add(t);
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[depth]=i;
            if(checkLegal(pos,depth)){
                dfs(res,n,depth+1,pos);
            }
        }
    }
    boolean checkLegal(int[] pos, int depth) {
        for (int j = 0; j < depth; j++) {
            if (pos[depth] == pos[j]
                    || Math.abs(depth - j) == Math.abs(pos[depth] - pos[j])) {
                return false;
            }
        }
        return true;
    }

}
