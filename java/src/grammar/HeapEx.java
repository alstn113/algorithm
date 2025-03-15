package grammar;

import java.util.PriorityQueue;

public class HeapEx {

    static int[][] arr = {
            {1, 2},
            {1, 4},
            {2, 1},
            {2, 3},
            {3, 1},
            {3, 4},
            {4, 3},
    };

    public static void main(String[] args) {
        // 인덱스 0에 대해 오름차순, 인덱스 1에 대해 내림차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] a : arr) {
            pq.offer(a);
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            System.out.println(poll[0] + " " + poll[1]);
        }
    }
}
