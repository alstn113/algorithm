package algorithm.최단_경로;

import java.util.*;

// 가중치가 있는 그래프에서 특정 노드에서 다른 모든 노드로의 최단 경로를 계산하는 알고리즘
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

    static List<List<Node>> graph = new ArrayList<>();
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

            graph.get(start).add(new Node(end, distance));
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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getNode();

            // 이미 길이가 더 짧은 경로가 있다면 무시
            if (distance[now] < dist) {
                continue;
            }

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (Node nd : graph.get(now)) {
                int cost = dist + nd.getDistance();

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[nd.getNode()]) {
                    distance[nd.getNode()] = cost;
                    pq.offer(new Node(nd.getNode(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    private final int node;
    private final int distance;

    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}
