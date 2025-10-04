import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inouts = new HashMap<>();
        Map<String, Integer> st = new HashMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            int time = getTime(split[0]);
            String num = split[1];
            String action = split[2];
            
            if (action.equals("IN")) {
                inouts.put(num, time);
            } else {
                int inTime = inouts.get(num);
                inouts.remove(num);
                st.put(num, st.getOrDefault(num, 0) + time - inTime);
            }
        }
        
        int lastTime = getTime("23:59");
        for (Map.Entry<String, Integer> entry : inouts.entrySet()) {
            String num = entry.getKey();
            int inTime = entry.getValue();
            
            st.put(num, st.getOrDefault(num, 0) + lastTime - inTime);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : st.entrySet()) {
            int number = Integer.parseInt(entry.getKey());
            System.out.println(number + " " + entry.getValue());
            if (entry.getValue() <= fees[0]) {
                result.add( List.of(number, fees[1]) );
                continue;
            }
         
            int v = fees[1] + (int) (Math.ceil((double) (entry.getValue() - fees[0]) / fees[2]) * fees[3]);
            result.add(List.of(number, v));
        }
        
        result.sort((o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });
        return result.stream().map(v -> v.get(1)).mapToInt(i -> i).toArray();
    }
    
    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);
        return h + m;
    }
}