import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> q = new LinkedList<>();
        int result = 0;
        
        for (int i=0; i<cities.length; i++) {
            String target = cities[i].toUpperCase();
            if (q.contains(target)) {
                q.remove(target);
                q.offer(target);
                result += 1;
            } else {
                if (q.size() == cacheSize) {
                    q.poll();
                }
                q.offer(target);
                result += 5;
            }
        }
        return result;
    }
}