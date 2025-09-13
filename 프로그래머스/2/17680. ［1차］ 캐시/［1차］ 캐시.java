import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> q = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.contains(city)) {
                q.remove(city);
                q.offer(city);
                answer += 1;
            } else {
                if (q.size() < cacheSize) {
                    q.offer(city);
                } else if (cacheSize > 0) {
                    q.poll();
                    q.offer(city);
                }
                answer += 5;
            }
        }

        return answer;
    }
}