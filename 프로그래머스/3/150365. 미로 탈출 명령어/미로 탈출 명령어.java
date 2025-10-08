import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] ds = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x = x - 1;
        y = y - 1;
        r = r - 1;
        c = c - 1;

        // d l r u 순으로 탐색
        int dis = Math.abs(x - r) + Math.abs(y - c);
        if (k < dis || (k - dis) % 2 != 0) {
            return "impossible";
        }

        List<String> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, k, ""));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cx = node.x;
            int cy = node.y;
            int cnt = node.cnt;
            int newCnt = cnt - 1;

            if (cnt == 0 && cx == r && cy == c) {
                return node.s;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                int newDis = Math.abs(r - nx) + Math.abs(c - ny);
                if (newCnt < newDis || (newCnt - newDis) % 2 != 0) {
                    continue;
                }

                q.offer(new Node(nx, ny, newCnt, node.s + ds[i]));
                break;
            }
        }

        return "impossible";
    }

    class Node {
        int x;
        int y;
        int cnt;
        String s;

        public Node(int x, int y, int cnt, String s) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.s = s;
        }
    }
}