import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    static int cnt = 0;

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (String s : operations) {
            if (s.equals("D 1")) {
                if (cnt == 0) {
                    continue;
                }
                poll(maxQ, map);

            } else if (s.equals("D -1")) {
                if (cnt == 0) {
                    continue;
                }
                poll(minQ, map);
            } else {
                int v = Integer.parseInt(s.split(" ")[1]);
                cnt += 1;
                map.put(v, map.getOrDefault(v, 0) + 1);
                maxQ.offer(v);
                minQ.offer(v);
            }
        }

        if (cnt == 0) {
            return new int[] { 0, 0 };
        }

        if (cnt == 1) {
            int v = poll(maxQ, map);
            return new int[] { v, v };
        }
        return new int[] { poll(maxQ, map), poll(minQ, map) };
    }

    public int poll(PriorityQueue<Integer> q, Map<Integer, Integer> map) {
        while (true) {
            int v = q.poll();
            if (map.get(v) == 0) {
                continue;
            }
            map.put(v, map.get(v) - 1);
            cnt -= 1;
            return v;
        }
    }
}