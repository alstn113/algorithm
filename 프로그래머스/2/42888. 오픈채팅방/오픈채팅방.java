import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> result = new ArrayList<>(); // command, uid
        Map<String, String> nameMap = new HashMap<>();

        for (String r : record) {
            String[] split = r.split(" ");

            String command = split[0];

            if (command.equals("Enter")) {
                String uid = split[1];
                String name = split[2];

                result.add(new String[]{command, uid, name});
                nameMap.put(uid, name);
            } else if (command.equals("Leave")) {
                String uid = split[1];
                result.add(new String[]{command, uid});
            } else {
                String uid = split[1];
                String name = split[2];
                nameMap.put(uid, name);
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String[] r = result.get(i);
            String name = nameMap.get(r[1]);

            if (r[0].equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
