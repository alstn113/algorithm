package kakao.s5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    int N;
    int M;
    Map<Integer, int[]> map;

    int[] dr = {0, 0, 0, 1, -1};
    int[] dc = {0, 1, -1, 0, 0};

    public int[][] solution(int[][] board, int[][] commands) {
        N = board.length;
        M = board[0].length;
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                int key = board[i][j];
                if (!map.containsKey(key)) {
                    map.put(key, new int[]{i, j, i, j});
                } else {
                    int[] value = map.get(key);
                    value[0] = Math.min(value[0], i);
                    value[1] = Math.min(value[1], j);
                    value[2] = Math.max(value[2], i);
                    value[3] = Math.max(value[3], j);
                }
            }
        }

        for (int[] command : commands) {
            int id = command[0];
            int dir = command[1];

            if (!map.containsKey(id)) {
                continue;
            }

            Set<Integer> visited = new HashSet<>();
            List<Integer> chain = new ArrayList<>();

            boolean possible = getPushChain(id, dir, visited, chain);

            if (possible) {
                Collections.reverse(chain);
                for (int appId : chain) {
                    int[] newBox = calculateNewBox(appId, dir);
                    map.put(appId, newBox);
                }
            }
        }

        int[][] result = new int[N][M];
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int id = entry.getKey();
            int[] arr = entry.getValue();
            int r1 = arr[0];
            int c1 = arr[1];
            int r2 = arr[2];
            int c2 = arr[3];

            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    result[i][j] = id;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }

    private boolean getPushChain(int id, int dir, Set<Integer> visited, List<Integer> chain) {
        visited.add(id);

        int[] nextBox = calculateNewBox(id, dir);

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int otherId = entry.getKey();
            if (otherId == id) {
                continue;
            }

            int[] otherBox = entry.getValue();
            if (isOverlap(nextBox, otherBox)) {
                if (visited.contains(otherId)) {
                    return false;
                }

                if (!getPushChain(otherId, dir, visited, chain)) {
                    return false;
                }
            }
        }

        chain.add(id);
        return true;
    }

    private int[] calculateNewBox(int id, int dir) {
        int[] box = map.get(id);
        int r1 = box[0];
        int c1 = box[1];
        int r2 = box[2];
        int c2 = box[3];

        int h = r2 - r1;
        int w = c2 - c1;

        int nr1 = r1 + dr[dir];
        int nc1 = c1 + dc[dir];
        int nr2 = r2 + dr[dir];
        int nc2 = c2 + dc[dir];

        boolean out = (nr1 < 0 || nr2 >= N || nc1 < 0 || nc2 >= M);

        if (!out) {
            return new int[]{nr1, nc1, nr2, nc2};
        } else {
            if (dir == 1) {
                return new int[]{r1, 0, r2, w};
            } else if (dir == 2) {
                return new int[]{r1, M - 1 - w, r2, M - 1};
            } else if (dir == 3) {
                return new int[]{0, c1, h, c2};
            } else {
                return new int[]{N - 1 - h, c1, N - 1, c2};
            }
        }
    }

    public boolean isOverlap(int[] arr1, int[] arr2) {
        if (arr1[0] > arr2[2] || arr2[0] > arr1[2]) {
            return false;
        }
        return arr1[1] <= arr2[3] && arr2[1] <= arr1[3];
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        int[][] test1 = p.solution(
                new int[][]{
                        {0, 2, 2, 0, 0, 0, 0, 0},
                        {0, 2, 2, 0, 0, 4, 4, 0},
                        {0, 3, 3, 3, 1, 4, 4, 0},
                        {0, 3, 3, 3, 0, 0, 0, 0},
                        {0, 3, 3, 3, 5, 5, 6, 0},
                        {0, 0, 0, 0, 5, 5, 0, 0}
                },
                new int[][]{
                        {3, 1},
                        {3, 1}
                }
        );
        boolean test1Correct = Arrays.deepEquals(test1, new int[][]{
                {0, 0, 2, 2, 0, 0, 0, 0},
                {4, 4, 2, 2, 0, 0, 0, 0},
                {4, 4, 0, 3, 3, 3, 1, 0},
                {0, 0, 0, 3, 3, 3, 0, 0},
                {6, 0, 0, 3, 3, 3, 5, 5},
                {0, 0, 0, 0, 0, 0, 5, 5}
        });
        int[][] test2 = p.solution(
                new int[][]{
                        {0, 9, 1, 1, 6, 0, 0, 0},
                        {2, 2, 1, 1, 0, 0, 0, 0},
                        {2, 2, 3, 4, 4, 4, 0, 0},
                        {5, 0, 0, 4, 4, 4, 7, 0},
                        {0, 0, 0, 4, 4, 4, 8, 8},
                        {0, 0, 0, 0, 0, 0, 8, 8}
                },
                new int[][]{
                        {2, 1},
                        {3, 1},
                        {9, 2},
                        {4, 1}
                }
        );
        boolean test2Correct = Arrays.deepEquals(test2, new int[][]{
                {8, 8, 0, 1, 1, 6, 0, 0},
                {8, 8, 0, 1, 1, 0, 0, 0},
                {4, 4, 4, 9, 3, 0, 0, 0},
                {4, 4, 4, 7, 2, 2, 0, 0},
                {4, 4, 4, 0, 2, 2, 0, 0},
                {0, 5, 0, 0, 0, 0, 0, 0}
        });
        int[][] test3 = p.solution(
                new int[][]{
                        {1, 1, 0},
                        {1, 1, 0}
                },
                new int[][]{
                        {1, 4},
                        {1, 3},
                        {1, 2}
                }
        );
        boolean test3Correct = Arrays.deepEquals(test3, new int[][]{
                {0, 1, 1},
                {0, 1, 1}
        });

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
    }
}
