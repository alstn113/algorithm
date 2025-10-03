import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] clear = new int[N+2]; // N+1까지 들어올 수 있음
        
        for (int stage : stages) {
            clear[stage] += 1;
        }
        
        int total = stages.length;
        List<Stage> result = new ArrayList<>();
        
        for (int i=1; i<=N; i++) {
            if (clear[i] == 0 || total == 0) {
                result.add(new Stage(i, 0));
            } else {
                double f = (double) clear[i] / total;
                result.add(new Stage(i, f));
            }
            total -= clear[i];
        }
        
        result.sort((o1, o2) -> {
            if (Double.compare(o2.failure, o1.failure) == 0) {
                return Integer.compare(o1.num, o2.num);
            }
            return Double.compare(o2.failure, o1.failure);
        });
        
        return result.stream().mapToInt(v -> v.num).toArray();
    }
    
    class Stage {
        int num;
        double failure;
        
        public Stage(int num, double failure) {
            this.num = num;
            this.failure = failure;
        }
    }
}
