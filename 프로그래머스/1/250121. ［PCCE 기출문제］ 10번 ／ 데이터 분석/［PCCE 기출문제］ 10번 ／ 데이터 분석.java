import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dic = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );

        List<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            if (d[dic.get(ext)] < val_ext) {
                list.add(d);
            }
        }

        list.sort((o1, o2) -> {
            int v = dic.get(sort_by);
            return o1[v] - o2[v];
        });

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}