import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static final int INF = (int) 1e9;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    public int solution(int N, int[][] road, int K) {
        distance = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(distance, INF);

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int distance = r[2];

            // 양방향 그래프
            graph.get(start).add(new Node(end, distance));
            graph.get(end).add(new Node(start, distance));
        }

        // 1번에서 시작
        dijkstra(1);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public void dijkstra(int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(num, 0));
        distance[num] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.node;

            // 이미 길이가 더 짧은 경로가 있다면 무시
            if (distance[now] < dist) {
                continue;
            }

            for (Node nd : graph.get(now)) {
                int cost = dist + nd.distance;

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[nd.node]) {
                    distance[nd.node] = cost;
                    pq.offer(new Node(nd.node, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    public int node;
    public int distance;

    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}