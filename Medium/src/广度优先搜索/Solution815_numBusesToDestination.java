package 广度优先搜索;

import java.util.*;

public class Solution815_numBusesToDestination {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        return bfs(routes, source, target);
    }

    private int bfs(int[][] routes, int source, int target) {
        //车站 和车站所处的路线
        Map<Integer, Set<Integer>> stationAndLine = new HashMap<>();
        //经过的路线
        Deque<Integer> d = new ArrayDeque<>();
        //进入该路线所需距离
        Map<Integer, Integer> m = new HashMap<>();
        int n = routes.length;
        for (int line = 0; line < n; line++) {
            for (int station : routes[line]){
                if (station == source){
                    d.add(line);
                    m.put(line, 1);
                }
                Set<Integer> lineSet = stationAndLine.getOrDefault(station, new HashSet<>());
                lineSet.add(line);
                stationAndLine.put(station, lineSet);
            }
        }
        while (!d.isEmpty()){
            Integer currLine = d.poll();
            int step = m.get(currLine);
            for (int station : routes[currLine]){
                if (station == target){
                    return step;
                }
                //当前车站所处路线
                Set<Integer> lines = stationAndLine.get(station);
                if (lines.isEmpty()){
                    continue;
                }

                for (int line : lines){
                    if (!m.containsKey(line)){
                        m.put(line,step + 1);
                        d.add(line);
                    }
                }
            }
        }
        return -1;

    }
}
