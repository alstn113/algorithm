import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> counts = new ArrayList<>();
        for (int card : cards) {
            int v = card - 1;
            if (visited[v]) {
                continue;
            }

            int cnt = 1;
            visited[v] = true;
            int nextIndex = cards[v] - 1;
            while (true) {
                if (visited[nextIndex]) {
                    break;
                }

                visited[nextIndex] = true;
                nextIndex = cards[nextIndex] - 1;
                cnt += 1;
            }

            counts.add(cnt);
        }

        counts.sort((o1, o2) -> o2 - o1);

        if (counts.size() == 1) {
            return 0;
        }

        return counts.get(0) * counts.get(1);
    }
}