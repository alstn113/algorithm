package algorithm.구간_합;

// 특정 구간 내 쿼리를 빠르게 할 수 있는 트리
// 특정 구간 최대, 최소, 평균을 구할 수 있음.

// 쿼리 연산: O(log n) -> 전체 구간합은 n log n
// 단일 데이터 변경: O(log n)
// 데이터 변경과 쿼리가 잦은 문제에서 사용된다.
public class 세그먼트_트리 {

    static class SegmentTree {
        int[] tree;
        int n;

        // 생성자: 배열로 트리 빌드
        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n]; // 충분히 큰 크기
            build(arr, 1, 0, n - 1);
        }

        // 재귀적으로 트리 빌드
        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, node * 2, start, mid);
                build(arr, node * 2 + 1, mid + 1, end);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        // 구간 합 쿼리: [l, r]
        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0; // 범위 밖
            }
            if (l <= start && end <= r) {
                return tree[node]; // 범위 안
            }
            int mid = (start + end) / 2;
            return query(node * 2, start, mid, l, r)
                    + query(node * 2 + 1, mid + 1, end, l, r);
        }

        // 단일 값 업데이트
        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(node * 2, start, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, end, idx, val);
                }
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 3, 5, 7, 9, 11};
            SegmentTree st = new SegmentTree(arr);

            System.out.println("구간 합 [1,3]: " + st.query(1, 0, arr.length - 1, 1, 3));

            System.out.println("값 업데이트 arr[1]=10");
            st.update(1, 0, arr.length - 1, 1, 10);

            System.out.println("구간 합 [1,3]: " + st.query(1, 0, arr.length - 1, 1, 3));

        }
    }
}
