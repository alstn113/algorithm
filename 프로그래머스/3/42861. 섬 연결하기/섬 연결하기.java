import java.util.Arrays;

class Solution {

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] node : costs) {
            int from = node[0];
            int to = node[1];
            int cost = node[2];

            if (findParent(from) != findParent(to)) {
                unionParent(from, to);
                answer += cost;
            }
        }

        return answer;
    }

    public int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}