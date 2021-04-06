package 深度优先搜索;

import java.util.Deque;
import java.util.LinkedList;

public class Solution79_exist {
    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};
    private String word;
    private char[][] board;
    public static void main(String[] args) {
         char[][] board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new Solution79_exist().exist(board,"ABCESEEEFS"));
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        this.word=word;
        this.board=board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(visited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(boolean[][] visited, int x, int y, int k){
        if (k == word.length() - 1) {
            return board[x][y] == word.charAt(k);
        }
        if (board[x][y] == word.charAt(k)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && visited[nx][ny] == false ) {
                    if (dfs(visited, nx, ny, k + 1)){
                        return true;
                    }
                }
            }
            visited[x][y]=false;
        }
        return false;
    }
}
