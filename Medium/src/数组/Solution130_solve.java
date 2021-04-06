package 数组;

import java.util.Arrays;
import java.util.Collections;

public class Solution130_solve {
    public static void main(String[] args) {
        char[][] board={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        new Solution130_solve().solve(board);
        System.out.println(Arrays.deepToString(board));

    }
    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0]=='O'){
                dfs(board, i, 0);
            }
            if (board[i][m-1]=='O'){
                dfs(board, i, m - 1);
            }

        }
        for (int i = 0; i < m ; i++) {
            if (board[0][i]=='O'){
                dfs(board, 0, i);
            }
            if (board[n-1][i]=='O'){
                dfs(board, n-1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.'){
                    board[i][j]='O';
                }
                else if (board[i][j]=='O'){
                    board[i][j]='X';
                }


            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        board[i][j]='.';
        for (int k = 0; k < 4; k++) {
            int nx=i+dx[k];
            int ny=j+dy[k];
            if (0<=nx&&nx<board.length&&0<=ny&&ny<board[0].length&&board[nx][ny]=='O'){
                dfs(board,nx,ny);
            }
        }
    }
}
