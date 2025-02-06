package algorithm.서로소_집합;

public class 서로소_집합 {

    static int V = 6;
    static int E = 4;
    static int[][] INPUT = {
            {2, 1},
            {3, 2},
            {4, 1},
            {5, 6},
    };

    static int[] parent = new int[V + 1];

    public static void main(String[] args) {
        // 부모 테이블을 자기 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 각 간선을 확인하며 union 연산 수행
        for (int i = 0; i < E; i++) {
            int a = INPUT[i][0];
            int b = INPUT[i][1];

            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력
        System.out.println("각 원소가 속한 집합: ");
        for (int i = 1; i <= V; i++) {
            System.out.print(findParent(i) + " ");
        }

        System.out.println();

        // 부모 테이블 내용 출력
        System.out.println("부모 테이블: ");
        for (int i = 1; i <= V; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]); // * 경로 압축
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
