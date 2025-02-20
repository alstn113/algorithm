import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Location> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Location(priorities[i], i));
        }

        while (true) {
            Location l = q.poll();
            boolean flag = false;
            for (Location temp : q) {
                if (l.priority < temp.priority) {
                    flag = true;
                    break;
                }
            }

            // 우선순위가 높은 것이 있음.
            if (flag) {
                q.offer(l);
            }
            // 우선순위가 가장 높음.
            else {
                if (l.location == location) {
                    return priorities.length - q.size();
                }
            }
        }
    }
}

class Location {

    public int priority;
    public int location;

    public Location(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}