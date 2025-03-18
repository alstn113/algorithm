import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static List<String> answer = new ArrayList<>();
    static boolean isFound = false;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        boolean[] visited = new boolean[tickets.length];
        List<String> line = new ArrayList<>();
        line.add("ICN");
        dfs("ICN", tickets, visited, line);

        return answer.toArray(String[]::new);
    }

    public void dfs(String current, String[][] tickets, boolean[] visited, List<String> line) {
        if (isFound) {
            return;
        }
        
        if (line.size() == tickets.length + 1) {
            answer = new ArrayList<>(line);
            isFound = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }

            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];

            if (from.equals(current)) {
                visited[i] = true;
                line.add(to);
                dfs(to, tickets, visited, new ArrayList<>(line));
                line.remove(line.size() - 1);
                visited[i] = false;
            }
        }
    }
}