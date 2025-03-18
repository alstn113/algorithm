import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Song>> map = new HashMap<>();
        Map<String, Integer> maxMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            maxMap.put(g, maxMap.getOrDefault(g, 0) + p);

            if (map.containsKey(g)) {
                map.get(g).offer(new Song(i, p));
                continue;
            }

            Queue<Song> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.plays == o2.plays) {
                    return o1.idx - o2.idx;
                }
                return o2.plays - o1.plays;
            });
            pq.offer(new Song(i, p));
            map.put(g, pq);
        }

        List<String> sortedList = new ArrayList<>(maxMap.keySet());
        sortedList.sort((o1, o2) -> maxMap.get(o2) - maxMap.get(o1));

        List<Integer> answer = new ArrayList<>();
        for (String g : sortedList) {
            Queue<Song> pq = map.get(g);
            answer.add(pq.poll().idx);

            if (!pq.isEmpty()) {
                answer.add(pq.poll().idx);
            }
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}

class Song {
    int idx;
    int plays;

    public Song(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }
}