import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        
        List<List<String>> result = new ArrayList<>();
        
        for (String r : record) {
            if (r.startsWith("Enter")) {
                String[] split = r.split(" ");
                map.put(split[1], split[2]);
                result.add(List.of("Enter", split[1]));
            } else if (r.startsWith("Change")) {
                String[] split = r.split(" ");
                map.put(split[1], split[2]);
            } else {
                String[] split = r.split(" ");               
                result.add(List.of("Leave", split[1]));
            }
        }
        
        String[] arr = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            String id = map.get(result.get(i).get(1));
            if (result.get(i).get(0).equals("Enter")) {
                arr[i] = String.format("%s님이 들어왔습니다.", id);
            } else {
                arr[i] = String.format("%s님이 나갔습니다.", id);                               
            }
        }
        
        return arr;
    }
}