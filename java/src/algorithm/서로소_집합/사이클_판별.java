package algorithm.서로소_집합;

public class 사이클_판별 {

    static int V = 3;
    static int E = 3;
    static int[][] INPUT = {
            {1, 2},
            {1, 3},
            {2, 3},
    };

    static int[] parent = new int[V + 1];

    public static void main(String[] args) {
        // 부모 테이블을 자기 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 사이클 발생 여부
        boolean cycle = false;

        // 각 간선을 확인하며 union 연산 수행
        for (int i = 0; i < E; i++) {
            int a = INPUT[i][0];
            int b = INPUT[i][1];

            // 아직 union 하지 않았는데 부모가 같다면 사이클 발생했다는 의미
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            } else {
                unionParent(a, b);
            }
        }

        System.out.println(cycle ? "사이클 O" : "사이클 X");
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b= findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
