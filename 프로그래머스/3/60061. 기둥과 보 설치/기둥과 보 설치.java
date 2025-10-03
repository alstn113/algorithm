import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean[][][] frames;

    public int[][] solution(int n, int[][] build_frame) {
        frames = new boolean[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int cd = frame[3];

            if (cd == 1) {
                if (type == 0) {
                    if (canBuildGi(x, y)) {
                        frames[y][x][0] = true;
                    }
                } else {
                    if (canBuildBo(x, y, n)) {
                        frames[y][x][1] = true;
                    }
                }
            }
            else {
                frames[y][x][type] = false;
                if (!canBuild(n)) {
                    frames[y][x][type] = true;
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                for (int t = 0; t < 2; t++) {
                    if (frames[y][x][t]) {
                        result.add(new int[]{x, y, t});
                    }
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public boolean canBuild(int n) {
        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                if (frames[y][x][0] && !canBuildGi(x, y)) {
                    return false;
                }
                if (frames[y][x][1] && !canBuildBo(x, y, n)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canBuildGi(int x, int y) {
        return y == 0
                || (y > 0 && frames[y - 1][x][0])
                || (x > 0 && frames[y][x - 1][1])
                || frames[y][x][1];
    }

    public boolean canBuildBo(int x, int y, int n) {
        return (y > 0 && (frames[y - 1][x][0] || frames[y - 1][x + 1][0])) // 한쪽 끝이 기둥 위
                || (x > 0 && x < n && frames[y][x - 1][1] && frames[y][x + 1][1]); // 양쪽 보 연결
    }
}
