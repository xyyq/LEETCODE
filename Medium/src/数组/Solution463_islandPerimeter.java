package 数组;

public class Solution463_islandPerimeter {
    public static void main(String[] args) {
        int[][] grid= {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new Solution463_islandPerimeter().islandPerimeter(grid));
    }
    public int islandPerimeter(int[][] grid) {
        int res=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(i==n-1&&j!=m-1){
                        res+=4-2*grid[i][j+1];
                    }else if(j==m-1&&i!=n-1){
                        res+=4-2*grid[i+1][j];
                    }else if(i==n-1&&j==m-1){
                        res+=4;
                    } else{
                        res+=4-2*(grid[i+1][j]+grid[i][j+1]);
                    }
                }
            }
        }
        return  res;
    }
}
