import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static int max = 0;

    public int[] solution(int n, int[] info) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(info, result, new ArrayList<>(), n, 0);

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        List<Integer> best = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            if (compareScore(best, result.get(i))) {
                best = result.get(i);
            }
        }

        return best.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int[] info, List<List<Integer>> result, List<Integer> cur, int limit, int curTarget) {
        if (curTarget == 10) {
            cur.add(limit);
            int diff = isWin(info, cur);
            if (isWin(info, cur) > 0) {
                if (diff > max) {
                    max = diff;
                    result.clear();
                    result.add(new ArrayList<>(cur));
                } else if (diff == max) {
                    result.add(new ArrayList<>(cur));
                }
            }
            cur.remove(cur.size() - 1);
            return;
        }

        if (info[curTarget] < limit) {
            int v = info[curTarget] + 1;
            cur.add(v);
            dfs(info, result, cur, limit - v, curTarget + 1);
            cur.remove(cur.size() - 1);
        }

        cur.add(0);
        dfs(info, result, cur, limit, curTarget + 1);
        cur.remove(cur.size() - 1);
    }

    public int isWin(int[] info, List<Integer> cur) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < 10; i++) {
            if (info[i] == 0 && cur.get(i) == 0) {
                continue;
            }

            if (info[i] >= cur.get(i)) {
                a += 10 - i;
            } else {
                b += 10 - i;
            }
        }

        return b - a;
    }

    public boolean compareScore(List<Integer> best, List<Integer> candidate) {
        for (int i = 10; i >= 0; i--) {
            if (best.get(i) != candidate.get(i)) {
                return candidate.get(i) > best.get(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
    }
}
