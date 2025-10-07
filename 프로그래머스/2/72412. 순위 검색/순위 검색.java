import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String inf : info) {
            String[] split = inf.split(" ");
            String lan = split[0];
            String type = split[1];
            String year = split[2];
            String food = split[3];
            String[] arr = new String[] {lan, type, year, food};
            int score = Integer.parseInt(split[4]);

            dfs(arr, score, new ArrayList<>(), map);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        int[] result = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String[] split = query[i].split(" and ");
            String lan = split[0];
            String type = split[1];
            String year = split[2];
            String[] ssplit = split[3].split(" ");
            String food = ssplit[0];
            int score = Integer.parseInt(ssplit[1]);

            String key = String.format("%s %s %s %s", lan, type, year, food);
            List<Integer> target = map.getOrDefault(key, new ArrayList<>());

            int left = 0;
            int right = target.size() - 1;
            int min = 0;

            while(left <= right) {
                int mid = (left + right) / 2;
                if (score <= target.get(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    min = left;
                }
            }

            result[i] = target.size() - min;
        }
        return result;
    }

    public void dfs(String[] arr, int score, List<String> cur, Map<String, List<Integer>> map) {
        if (cur.size() == 4) {
            String key = String.join(" ", cur);
            List<Integer> mapList = map.computeIfAbsent(key, k -> new ArrayList<>());
            mapList.add(score);
            return;
        }

        int idx = cur.size();
        cur.add(arr[idx]);
        dfs(arr, score, cur, map);
        cur.remove(cur.size() - 1);

        cur.add("-");
        dfs(arr, score, new ArrayList<>(cur), map);
        cur.remove(cur.size()-1);
    }
}