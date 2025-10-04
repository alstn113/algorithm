import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDate = getDate(today);
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int date = getDate(split[0]);
            int termDate  = map.get(split[1]);
            
            if (date + termDate - 1 < todayDate) {
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public int getDate(String date) {
        String[] split = date.split("\\.");
        int y = Integer.parseInt(split[0]) * 12 * 28;
        int m = Integer.parseInt(split[1]) * 28;
        int d = Integer.parseInt(split[2]);
        
        return y + m + d;
    }
}