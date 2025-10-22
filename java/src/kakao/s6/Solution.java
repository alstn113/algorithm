package kakao.s6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    String[] grid;
    int answer;
    int panelCnt;
    int N;
    int M;
    Map<Integer, int[]> panelMap;
    int[] ev;
    List<List<Integer>> graph;

    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        this.grid = grid;
        answer = Integer.MAX_VALUE;
        panelCnt = 0;

        N = grid.length;
        M = grid[0].length();

        ev = new int[2];
        findEv(grid);

        panelMap = new HashMap<>();
        panelCnt = panels.length;
        for (int i = 0; i < panels.length; i++) {
            int[] panel = panels[i];
            panelMap.put(i + 1, new int[]{panel[0], panel[1] - 1, panel[2] - 1});
        }

        int[] degrees = new int[panelCnt + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= panelCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] seq : seqs) {
            int start = seq[0];
            int end = seq[1];

            graph.get(start).add(end);
            degrees[end] += 1;
        }

        List<Integer> targetPanels = new ArrayList<>();
        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                targetPanels.add(i);
            }
        }
        int[] cur = panelMap.get(1);
        dfs(0, 0, new int[]{cur[0], cur[1], cur[2]}, degrees, targetPanels);

        return answer;
    }

    public void dfs(int cnt, int curPanelCnt, int[] cur, int[] degrees, List<Integer> targets) {
        if (curPanelCnt == panelCnt) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (Integer target : targets) {
            int[] newDegrees = Arrays.copyOf(degrees, degrees.length);
            List<Integer> nextTargets = new ArrayList<>(targets);
            nextTargets.remove(target);

            int[] end = panelMap.get(target);
            int dis = 0;

            // 같은 층인 경우 - A -> B
            if (cur[0] == end[0]) {
                dis += bfs(cur[1], cur[2], end[1], end[2]);
            } else {
                // 다른 층인 경우 - A -> 엘베, 엘베 -> B
                dis += bfs(cur[1], cur[2], ev[0], ev[1]);
                dis += Math.abs(cur[0] - end[0]);
                dis += bfs(ev[0], ev[1], end[1], end[2]);
            }

            for (int t : graph.get(target)) {
                newDegrees[t] -= 1;
                if (newDegrees[t] == 0) {
                    nextTargets.add(t);
                }
            }

            dfs(cnt + dis, curPanelCnt + 1, panelMap.get(target), newDegrees, nextTargets);
        }
    }

    // 걸린시간
    public int bfs(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == ex && cur[1] == ey) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (grid[nx].charAt(ny) == '#') {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                q.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }

    public void findEv(String[] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i].charAt(j) == '@') {
                    ev = new int[]{i, j};
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        int test1 = p.solution(
                3,
                new String[]{
                        ".#.##..",
                        ".#..##.",
                        ".......",
                        "##.###.",
                        ".@.#...",
                        "...#..."

                },
                new int[][]{
                        {2, 3, 4}, {2, 5, 6}, {1, 1, 1}, {3, 6, 3}
                },
                new int[][]{
                        {3, 2}, {1, 2}, {4, 1}, {4, 3}
                }
        );
        boolean test1Correct = test1 == 36;

        int test2 = p.solution(
                1,
                new String[]{
                        "@......",
                        ".######",
                        ".......",
                        "######.",
                        ".......",
                        ".####..",
                        "....#.."
                },
                new int[][]{
                        {1, 7, 4}, {1, 3, 5}, {1, 1, 3}
                },
                new int[][]{
                        {1, 3}, {3, 2}
                }
        );
        boolean test2Correct = test2 == 31;

        int test3 = p.solution(
                4,
                new String[]{
                        "........#",
                        "........#",
                        "@.......#",
                        ".#.#....#",
                        "........#",
                        "#........",
                        "#.#..####",
                        "..#..####",
                        ".....####"
                },
                new int[][]{
                        {2, 9, 1}, {2, 1, 8},
                        {1, 1, 3}, {3, 3, 2}, {1, 2, 8}
                },
                new int[][]{
                        {1, 2}, {2, 3}, {3, 4},
                        {4, 5}
                }
        );
        boolean test3Correct = test3 == 47;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
    }

}
