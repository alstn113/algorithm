import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        int start = 0;
        int time = 0;

        int sum = 0;
        do {
            // 트럭이 끝까지 가면 트럭을 내린다.
            if (bridge.size() == bridge_length) {
                sum -= bridge.poll();
            }

            // 다음 트럭이 다리에 올라갈 수 있으면 올린다.
            if (start < truck_weights.length && sum + truck_weights[start] <= weight) {
                sum += truck_weights[start];
                bridge.add(truck_weights[start]);
                start += 1;
            }
            // 비어 있는 공간을 채우기 위해 0을 넣는다.
            else {
                bridge.add(0);
            }

            time += 1;
        } while (sum != 0);

        return time;
    }
}