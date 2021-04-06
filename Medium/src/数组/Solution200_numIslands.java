package 数组;

public class Solution200_numIslands {

    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};

    public int numIslands(char[][] grid) {
        int res=0;
        int line=grid.length;
        int column=grid[0].length;
        for (int i = 0; i <line ; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return  res;
    }
    public void dfs(char[][] grid, int x, int y){
        grid[x][y]='2';
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i],ny=y+dy[i];
            if (0<=nx&&nx<m&&0<=ny&&ny<n&&grid[nx][ny]=='1'){
                dfs(grid,nx,ny);
            }
        }
    }
}
