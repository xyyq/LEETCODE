package 动态规划;

import java.util.*;

public class Solution909_snakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int[] one = twoToOne(board);
        if (board[0][0] != -1){
            return -1;
        }
        int res = bfs(one);
        return res;

    }

    private int bfs(int[] one) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        queue.add(1);
        map.put(1,0);
        while (!queue.isEmpty()){
            int position = queue.poll();
            int step = map.get(position);
            if (position == one.length - 1){
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int next = i + position;
                if (next <= 0 || next > one.length - 1){
                    continue;
                }
                if (one[next] != -1){
                    next = one[next];
                }
                if (map.containsKey(next)) continue;
                queue.add(next);
                map.put(next, step + 1);
            }
        }
        return -1;
    }

    public int[] twoToOne(int[][] nums){
        int size = nums.length;
        int[] result = new int[size * size + 1];
        int point = 1;
        boolean reserve = false;
        for (int i = size - 1; i >= 0 ; i--) {
            if (!reserve){
                for (int j = 0; j < size; j++) {
                    result[point++] = nums[i][j];
                }
                reserve = true;
            }else {
                for (int j = size - 1; j >= 0 ; j--) {
                    result[point++] = nums[i][j];
                }
                reserve = false;
            }
        }
        return result;
    }

}
