import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int s : stages) {
            dic.put(s, dic.getOrDefault(s, 0) + 1);
        }

        List<Stage> stageList = new ArrayList<>();
        int sum = stages.length;
        for (int i=1; i<=N; i++) {
            int v = dic.getOrDefault(i, 0);
            double failure;
            if (v == 0) {
                failure = 0;
                System.out.println(failure);
            } else {
                failure = (double) v / sum;
                System.out.println(v + " " + sum);
            }
            sum -= v;

            stageList.add(new Stage(i, failure));
        }

        return stageList.stream()
               .sorted((o1, o2) -> {
                    if (o1.failure == o2.failure) {
                        return Integer.compare(o1.stage, o2.stage);
                    }
                    return Double.compare(o2.failure, o1.failure);
                })
                .mapToInt(s -> s.stage)
                .toArray();
    }
}

class Stage {

    public int stage;
    public double failure;

    public Stage(int stage, double failure) {
        this.stage = stage;
        this.failure = failure;
    }
}