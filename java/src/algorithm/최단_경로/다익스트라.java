package algorithm.최단_경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 가중치가 있는 그래프에서 특정 노드에서 다른 모든 노드들로의 최단 경로를 계산하는 알고리즘

// 유형
// BFS 는 모두 1인 또는 동일한 가중치가 있는 그래프에서 최단 경로를 찾는 데 사용
// 다익스트라 알고리즘은 양의 가중치가 있을 때 사용하고 우선순위 큐를 사용
// 네트워크 비용, 도로 거리, 배송 경로 등
public class 다익스트라 {

    static final int INF = (int) 1e9;

    static final int N = 4; // 노드의 개수
    static final int M = 8; // 간선의 개수
    static final int START = 2; // 시작 노드

    static final int[][] input = { // 시작 노드, 도착 노드, 가중치
            {1, 2, 4},
            {1, 3, 2},
            {1, 4, 7},
            {2, 1, 1},
            {2, 3, 5},
            {3, 1, 2},
            {3, 4, 4},
            {4, 2, 3},
    };

    static List<List<int[]>> graph = new ArrayList<>();
    static int[] distance = new int[N + 1];

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(distance, INF);

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int start = input[i][0];
            int end = input[i][1];
            int distance = input[i][2];

            graph.get(start).add(new int[]{end, distance});
        }

        // 다익스트라 알고리즘 수행
        dijkstra(START);

        // 모든 노드로 가기 위한 최단 거리 출력
        for (int i = 1; i <= N; i++) {
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});

        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int dist = cur[1];

            if (distance[now] < dist) {
                continue;
            }

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int[] node : graph.get(now)) {
                int cost = dist + node[1];

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[node[0]]) {
                    distance[node[0]] = cost;
                    pq.offer(new int[]{node[0], cost});
                }
            }
        }
    }
}