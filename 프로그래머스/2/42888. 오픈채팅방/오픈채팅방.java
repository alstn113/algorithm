import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> ids = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for (String r : record) {
            String[] split = r.split(" ");
            
            String action = split[0];
            String id = split[1];
            
            if (action.equals("Enter")) {
                String name = split[2];
                ids.put(id, name);                
                result.add(List.of("Enter", id));
                continue;
            }
            
            if (action.equals("Change")) {
                String name = split[2];
                ids.put(id, name);
                continue;
            }
            
            if (action.equals("Leave")) {
                result.add(List.of("Leave", id));
            }
        }

        String[] answer = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            if (result.get(i).get(0).equals("Enter")) {
                answer[i] = String.format("%s님이 들어왔습니다.", ids.get(result.get(i).get(1)));
            } else {
                answer[i] = String.format("%s님이 나갔습니다.", ids.get(result.get(i).get(1)));
            }
        }
        return answer;
    }
}