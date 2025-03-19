import java.util.HashSet;
import java.util.Set;

class Solution {

    // 동일한 것들 제외하기!
    static Set<Set<String>> answers = new HashSet<>();
    static boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(0, user_id, banned_id, new HashSet<>());

        return answers.size();
    }

    public void dfs(int curIdx, String[] user_id, String[] banned_id, Set<String> line) {
        if (banned_id.length == curIdx) {
            answers.add(line);
            return;
        }

        String banned = banned_id[curIdx];
        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];

            if (visited[i]) {
                continue;
            }
            if (!isBannedable(user, banned)) {
                continue;
            }

            visited[i] = true;
            line.add(user);
            dfs(curIdx + 1, user_id, banned_id, new HashSet<>(line));
            line.remove(user);
            visited[i] = false;
        }
    }

    public boolean isBannedable(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            char userChar = user.charAt(i);
            char bannedChar = banned.charAt(i);

            if (bannedChar == '*') {
                continue;
            }
            if (userChar != bannedChar) {
                return false;
            }
        }

        return true;
    }
}