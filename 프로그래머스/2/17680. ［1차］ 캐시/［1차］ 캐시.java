import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> cache = new LinkedList<>();
        int answer = 0;

        for (String city : cities) {
            String cityLower = city.toLowerCase();
            
            // cache hit
            if (cache.contains(cityLower)) {
                cache.remove(cityLower);
                cache.offer(cityLower);
                answer += 1;
            }
            // cache miss
            else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.offer(cityLower);
                answer += 5;
            }
        }

        return answer;
    }
}
