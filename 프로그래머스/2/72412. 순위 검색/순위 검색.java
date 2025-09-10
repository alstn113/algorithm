import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String inf : info) {
            String[] split = inf.split(" ");
            dfs(split, 0, new ArrayList<>());
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] split2 = split[3].split(" ");
            
            String lang = split[0];
            String job = split[1];
            String career = split[2];
            String food =  split2[0];
            int score = Integer.parseInt(split2[1]);
            String key = String.join(" ", Arrays.asList(lang, job, career, food));

            List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
            answer[i] = lowerBoundCount(scores, score);
        }

        return answer;
    }

    private void dfs(String[] arr, int depth, List<String> key) {
        if (depth == 4) {
            String k = String.join(" ", key);
            int score = Integer.parseInt(arr[4]);
            map.computeIfAbsent(k, kk -> new ArrayList<>()).add(score);
            return;
        }

        key.add(arr[depth]);
        dfs(arr, depth + 1, key);
        key.remove(key.size() - 1);

        key.add("-");
        dfs(arr, depth + 1, key);
        key.remove(key.size() - 1);
    }

    private int lowerBoundCount(List<Integer> scores, int target) {
        int left = 0;
        int right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return scores.size() - left;
    }
}