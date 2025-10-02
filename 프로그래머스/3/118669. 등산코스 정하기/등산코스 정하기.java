import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    int INF = (int) 1e9;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
         
        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int cost = path[2];
            graph.get(a).add(new int[]{b, cost});
            graph.get(b).add(new int[]{a, cost});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int gate : gates) {
            dist[gate] = 0;
            pq.offer(new int[]{0, gate}); // intensity, gate number
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int intensity = cur[0];
            int node = cur[1];

            if (dist[node] < intensity) {
                continue;
            }
            if (Arrays.stream(summits).anyMatch(v -> v == node)) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int cost = next[1];

                int newIntensity = Math.max(intensity, cost);
                if (dist[nextNode] > newIntensity) {
                    dist[nextNode] = newIntensity;
                    pq.offer(new int[]{newIntensity, nextNode});
                }
            }
        }

        Arrays.sort(summits);
        int resultTarget = summits[0];
        int resultCost = dist[summits[0]];

        for (int i = 1; i < summits.length; i++) {
            if (dist[summits[i]] < resultCost) {
                resultTarget = summits[i];
                resultCost = dist[summits[i]];
            }
        }

        return new int[]{resultTarget, resultCost};
    }
}