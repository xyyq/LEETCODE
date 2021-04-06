package 数组;

public class Solution695_maxAreaOfIsland {
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        int count=0;
        int res=0;
        public int maxAreaOfIsland(int[][] grid) {
            int line=grid.length;
            int column=grid[0].length;
            for (int i = 0; i <line; i++) {
                for (int j = 0; j < column; j++) {
                    if(grid[i][j]==1){
                        dfs(grid,i,j);
                        res = Math.max(res,count);
                        count=0;
                    }
                }
            }
            return res;
        }
        public void dfs(int[][] grid,int x,int y){
            count++;
            grid[x][y]=2;
            for (int i = 0; i < 4; i++) {
                int nx=x+dx[i],ny=y+dy[i];
                if (inArea(grid,nx,ny)&&grid[nx][ny]==1){
                    dfs(grid,nx,ny);
                }
            }
        }
        public boolean inArea(int[][] grid,int nx,int ny){
            return 0<=nx&&nx<grid.length&&0<=ny&&ny<grid[0].length;
        }
}

