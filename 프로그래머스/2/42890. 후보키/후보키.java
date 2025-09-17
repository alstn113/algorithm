import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    String[][] r;

    public int solution(String[][] relation) {
        int n = relation[0].length;
        r = relation;
        List<Set<Integer>> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Set<Integer>> all = new ArrayList<>();
            dfs(n, i, 0, new HashSet<>(), all);
            for (Set<Integer> k : all) {
                boolean flag = false;
                for (Set<Integer> v : a) {
                    if (k.containsAll(v)) {
                        flag = true;
                        break;
                    }

                }
                if (!flag && check(k)) {
                    a.add(k);
                }
            }
        }
        return a.size();
    }

    public void dfs(int n, int limit, int startIdx, Set<Integer> arr, List<Set<Integer>> all) {
        if (arr.size() == limit) {
            all.add(new HashSet<>(arr));
            return;
        }

        for (int i = startIdx; i < n; i++) {
            arr.add(i);
            dfs(n, limit, i + 1, arr, all);
            arr.remove(i);
        }
    }

    public boolean check(Set<Integer> arr) {
        int total = r.length;

        Set<String> set = new HashSet<>();
        for (String[] s : r) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(s[i]).append(" ");
            }
            set.add(sb.toString());
        }

        return set.size() == total;
    }
}