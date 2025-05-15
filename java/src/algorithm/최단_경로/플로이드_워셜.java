package algorithm.최단_경로;

import java.util.*;

// 모든 노드에서 모든 노드로 가는 최단 경로를 구하는 알고리즘
// 음의 가중치 가능, 음의 사이클은 불가능 O(N^3)
public class 플로이드_워셜 {

    public static final int INF = (int) 1e9;

    public static final int N = 4;
    public static final int M = 7;
    public static final int[][] input = {
            {1, 2, 4},
            {1, 4, 6},
            {2, 1, 3},
            {2, 3, 7},
            {3, 1, 5},
            {3, 4, 4},
            {4, 3, 2},
    };

    public static final int[][] graph = new int[N + 1][N + 1];

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i<=N; i ++) {
            for (int j = 1; j<=N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int start = input[i][0];
            int end = input[i][1];
            int distance = input[i][2];

            graph[start][end] = distance;
        }

        // 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 결과 출력
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
