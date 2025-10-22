package kakao.s4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    int answer;
    List<List<List<Integer>>> graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        graph = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                graph.get(i).add(new ArrayList<>());
            }
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            List<List<Integer>> typeGraph = graph.get(type);
            typeGraph.get(x).add(y);
            typeGraph.get(y).add(x);
        }

        boolean[] inf = new boolean[n + 1];
        inf[infection] = true;

        dfs(k, n, 0, inf);

        return answer;
    }

    public void dfs(int k, int n, int cnt, boolean[] inf) {
        if (cnt == k) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (inf[i]) {
                    sum += 1;
                }
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            boolean[] newInf = Arrays.copyOf(inf, inf.length);
            boolean[] result = bfs(newInf, n, i);
            dfs(k, n, cnt + 1, result);
        }
    }

    public boolean[] bfs(boolean[] inf, int n, int type) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (inf[i]) {
                q.add(i);
            }
        }

        List<List<Integer>> cgraph = graph.get(type);

        while(!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> nodes = cgraph.get(cur);
            for (int node : nodes) {
                if (inf[node]) {
                    continue;
                }

                q.add(node);
                inf[node] = true;
            }
        }

        return inf;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test1 = s.solution(10, 1,
                new int[][]{
                        {1, 2, 1},
                        {1, 3, 1},
                        {1, 4, 3},
                        {1, 5, 2},
                        {5, 6, 1},
                        {5, 7, 1},
                        {2, 8, 3},
                        {2, 9, 2},
                        {9, 10, 1}
                }, 2
        );
        boolean test1Correct = test1 == 6;
        int test2 = s.solution(7, 6,
                new int[][]{
                        {1, 2, 3},
                        {1, 4, 3},
                        {4, 5, 1},
                        {5, 6, 1},
                        {3, 6, 2},
                        {3, 7, 2}
                }, 3);
        boolean test2Correct = test2 == 7;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
    }
}
