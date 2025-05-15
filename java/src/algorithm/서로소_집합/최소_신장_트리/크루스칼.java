package algorithm.서로소_집합.최소_신장_트리;

import java.util.ArrayList;
import java.util.List;

// 최소 신장 트리(Minimum Spanning Tree, MST): 그래프의 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
// 크루스칼 알고리즘: 가장 적은 비용으로 신장 트리를 찾는 알고리즘
public class 크루스칼 {

    static final int V = 7;
    static final int E = 9;
    static final int[][] INPUT = {
            {1, 2, 29},
            {1, 5, 75},
            {2, 3, 35},
            {2, 6, 34},
            {3, 4, 7},
            {4, 6, 23},
            {4, 7, 13},
            {5, 6, 53},
            {6, 7, 25},
    };

    static int[] parent = new int[V + 1];
    static List<Edge> edges = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) {
        // 부모 테이블을 자기 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < E; i++) {
            int from = INPUT[i][0];
            int to = INPUT[i][1];
            int weight = INPUT[i][2];

            edges.add(new Edge(from, to, weight));
        }

        // 간선의 비용을 기준으로 오름차순 정렬
        edges.sort((a, b) -> a.weight - b.weight);

        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            // 간선의 노드에 대해서 union 하기 전에 parent 가 같다면 사이클이 발생한다는 의미
            if (findParent(from) != findParent(to)) {
                unionParent(from, to);
                result += weight;
            }
        }

        System.out.println(result);
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}

class Edge {

    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}