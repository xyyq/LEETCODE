package 数组;

import java.util.Arrays;

public class UnionFind {


    int[] parent;
    int[] size;
    int n;
    int setCount;// 连通量的个数
    public UnionFind(int n){
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        Arrays.fill(parent,-1);


    }
    public int find(int x){
        if (parent[x]<0){
            parent[x] = x;
        }
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }else {
            if (size[rootX]<size[rootY]){
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            //rootX 为较大树
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            setCount--;
        }
    }
    public boolean same(int x , int y){
        return find(x)==find(y);
    }
}
