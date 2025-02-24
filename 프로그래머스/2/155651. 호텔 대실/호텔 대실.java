import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        List<Book> times = new ArrayList<>();
        for (String[] strings : book_time) {
            int start = getTime(strings[0]);
            int end = getTime(strings[1]);

            times.add(new Book(start, end));
        }

        times.sort((o1, o2) -> o1.start - o2.start);

        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Book time : times) {
            if (pq.isEmpty()) {
                pq.offer(time.end + 10);
                continue;
            }

            if (pq.peek() <= time.start) {
                pq.poll();
            } else {
                answer++;
            }
            
            pq.offer(time.end + 10);
        }

        return answer;
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        return h * 60 + m;
    }
}

class Book {
    int start;
    int end;

    public Book(int start, int end) {
        this.start = start;
        this.end = end;
    }
}