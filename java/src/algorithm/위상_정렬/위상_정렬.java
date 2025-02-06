package algorithm.위상_정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 위상 정렬: 순서가 정해져 있는 작업을 차례로 수행해야 할 때 사용하는 알고리즘
// 사이클이 없는 방향 그래프(DAG)에 대해서만 수행 가능하다.

// 진입 차수(Indegree): 특정한 노드로 들어오는 간선의 개수
// 진입 차수가 0인 노드부터 큐에 넣고, 큐에서 원소를 꺼낸 뒤 연결된 간선을 제거하는 방식으로 동작한다.
public class 위상_정렬 {

    static final int V = 7;
    static final int E = 7;
    static final int[][] INPUT = {
            {1, 2},
            {1, 5},
            {2, 3},
            {3, 4},
            {4, 7},
            {5, 6},
            {6, 4},
    };

    static int[] indegree = new int[V + 1];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입 차수 초기화
        Arrays.fill(indegree, 0);

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int a = INPUT[i][0];
            int b = INPUT[i][1];

            graph.get(a).add(b);

            // 진입 차수 증가
            indegree[b] += 1;
        }

        // 위상 정렬 함수
        topologicalSort();
    }

    public static void topologicalSort() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            // 해당 원소와 연결된 노드들의 진입 차수에서 1 빼기
            for (int next : graph.get(now)) {
                indegree[next] -= 1;

                // 새롭게 진입 차수가 0이 되는 노드를 큐에 삽입
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 위상 정렬 결과 출력
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
