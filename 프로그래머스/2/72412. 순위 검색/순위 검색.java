import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String inf : info) {
            String[] split = inf.split(" ");
            dfs(split, new ArrayList<>());
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort((o1, o2) -> o1 - o2);
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] ssplit = split[3].split(" ");
            String d = ssplit[0];

            String key = String.format("%s %s %s %s", split[0], split[1], split[2], d);
            int score = Integer.parseInt(ssplit[1]);

            List<Integer> arr = map.getOrDefault(key, new ArrayList<>());
            int left = 0;
            int right = arr.size() - 1;
            int tt = arr.size();

            while( left <= right) {
                int mid = (left  + right) / 2;

                if ( arr.get(mid) >= score) {
                    right = mid - 1;
                    tt = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = arr.size() - tt;
         }

        return result;
    }

    public void dfs(String[] split, List<String> arr) {
        if (arr.size() == 4) {
            int score = Integer.parseInt(split[4]);
            String key = String.join(" ", arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        int idx = arr.size();
        arr.add(split[idx]);
        dfs(split, arr);
        arr.remove(arr.size() - 1);

        arr.add("-");
        dfs(split, arr);
        arr.remove(arr.size() - 1);
    }
}