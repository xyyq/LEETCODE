package 回溯;

public class Solution52 {
    static  int count=0;
    static int midRes;
    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(7));
    }
    public int totalNQueens(int n) {
        dfs(n,0,new int[n],0);
        if (n%2==0){
            return count*2;
        }else {
            return midRes*2+count-midRes;
        }

    }
    public void dfs(int n,int depth,int[] pos,int line){
        if (depth==n){
            count++;
            if (line==n/2-1){
                midRes=count;
            }
            return;
        }

            for (int i = 0; i<(depth==0?(n+1)/2:n); i++) {
                pos[depth]=i;
                if (depth==0) line=i;
                if (checkLegal(pos,depth)){
                    dfs(n,depth+1,pos,line);
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
