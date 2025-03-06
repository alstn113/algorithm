import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        List<List<String>> rRoutes = new ArrayList<>();

        for (int[] route : routes) {
            List<String> temp = new ArrayList<>();

            int[] curP = points[route[0] - 1];
            temp.add(String.format("%d %d", curP[0], curP[1]));

            for (int i = 1; i < route.length; i++) {
                temp.addAll(move(points[route[i - 1] - 1], points[route[i] - 1]));
            }
            rRoutes.add(temp);
        }

        int answer = 0;
        boolean[] end = new boolean[routes.length];
        int endCount = 0;

        int i = 0;
        while (endCount != routes.length) {
            Map<String, Integer> map = new HashMap<>();
            for (int r = 0; r < rRoutes.size(); r++) {
                if (end[r]) {
                    continue;
                }

                if (i == rRoutes.get(r).size() - 1) {
                    end[r] = true;
                    endCount += 1;
                }

                String key = rRoutes.get(r).get(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (int v : map.values()) {
                if (v > 1) {
                    answer += 1;
                }
            }
            i += 1;
        }

        return answer;
    }

    public List<String> move(int[] currentP, int[] targetP) {
        List<String> history = new ArrayList<>();

        int tx = targetP[0];
        int ty = targetP[1];

        int cx = currentP[0];
        int cy = currentP[1];

        while (cx != tx || cy != ty) {
            if (cx != tx) {
                cx += (tx > cx) ? 1 : -1;
            } else {
                cy += (ty > cy) ? 1 : -1;
            }
            history.add(String.format("%d %d", cx, cy));
        }

        return history;
    }
}
