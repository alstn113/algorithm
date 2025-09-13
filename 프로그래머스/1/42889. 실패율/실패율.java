import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 도달 but not clear / 도달
        int players = stages.length;
        int[] dodal = new int[N + 2];
        for (int s : stages) {
            dodal[s] += 1;
        }

        List<Failure> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (dodal[i] == 0 || players == 0) {
                result.add(new Failure(i, 0));
            } else {
                result.add(new Failure(i, (double) dodal[i] / players));
            }
            players -= dodal[i];
        }

        result.sort((o1, o2) -> {
            if (o1.failureRate == o2.failureRate) {
                return o1.stage - o2.stage;
            }
            return Double.compare(o2.failureRate, o1.failureRate);
        });

        int[] answer = new int[N];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).stage;
        }
        return answer;
    }

    class Failure {
        int stage;
        double failureRate;

        public Failure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
}