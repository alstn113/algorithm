import java.util.ArrayList;
import java.util.List;

class Solution {

    int max = 0;
    List<List<Integer>> result = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        // 어피치보다 점수가 높아야 함
        // 그 중 최고 점수를 골라야 함.
        // 최고 점수가 같은 것이 여러 개라면 최저 점수를 더 많이 맞춘 경우

        int apeach = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0) {
                apeach += 10 - i;
            }
        }

        dfs(0, 0, apeach, new ArrayList<>(), n, info);

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        // 제일 낮은 점수가 오도록 정렬
        result.sort((o1, o2) -> {
            for (int i=10; i>-1; i--) {
                if (o1.get(i).equals(o2.get(i))) {
                    continue;
                }
                return o2.get(i) - o1.get(i);
            }
            return 1;
        });

        return result.get(0).stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int idx, int lion, int apeach, List<Integer> cur, int remain, int[] info) {
        if (idx == 11) {
            if (remain > 0) {
                cur.set(10, cur.get(10) + remain);
            }

            if (lion > apeach) {
                if (lion - apeach > max) {
                    max = lion - apeach;
                    result = new ArrayList<>();
                    result.add(new ArrayList<>(cur));
                } else if (lion - apeach == max) {
                    result.add(new ArrayList<>(cur));
                }
            }
            return;
        }

        if (info[idx] + 1 <= remain) {
            int newLion = lion;
            int newApeach = apeach;
            if (info[idx] == 0) {
                newLion += 10 - idx;
            } else {
                newLion += 10 - idx;
                newApeach += -10 + idx;
            }
            cur.add(info[idx] + 1);
            dfs(idx + 1, newLion, newApeach, cur, remain - info[idx] - 1, info);
            cur.remove(cur.size() - 1);
        }

        cur.add(0);
        dfs(idx + 1, lion, apeach, cur, remain, info);
        cur.remove(cur.size() - 1);
    }
}