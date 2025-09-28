import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, new HashSet<>());

        return result.size();
    }

    public void dfs(String[] user_id, String[] banned_id, Set<String> banned) {
        int idx = banned.size();
        if (idx == banned_id.length) {
            result.add(new HashSet<>(banned));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];
            if (banned.contains(user)) {
                continue;
            }

            if (ableToBan(banned_id[idx], user_id[i])) {
                banned.add(user);
                dfs(user_id, banned_id, banned);
                banned.remove(user);
            }
        }
    }

    public boolean ableToBan(String mask, String user) {
        int n = mask.length();
        int n1 = user.length();

        if (n != n1) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            char mc = mask.charAt(i);
            if (mc != '*' && mc != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}