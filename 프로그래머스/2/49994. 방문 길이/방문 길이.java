import java.util.HashSet;
import java.util.Set;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static String[] moveTypes = {"U", "D", "R", "L"};

    public int solution(String dirs) {
        Set<String> set = new HashSet<>();

        int cx = 0;
        int cy = 0;

        int answer = 0;
        for (String dir : dirs.split("")) {
            int nx = 0;
            int ny = 0;

            for (int i = 0; i < moveTypes.length; i++) {
                if (moveTypes[i].equals(dir)) {
                    nx = cx + dx[i];
                    ny = cy + dy[i];
                }
            }

            if (-5 > nx || nx > 5 || -5 > ny || ny > 5) {
                continue;
            }
    
            
            String path = createPath(cx, cy, nx, ny);
            String reversePath = createPath(nx, ny, cx, cy);

            if (!set.contains(path)) {
                set.add(path);
                set.add(reversePath);
                answer += 1;
            }

            cx = nx;
            cy = ny;
        }

        return answer;
    }
    
    public String createPath(int cx, int cy, int nx, int ny) {
        return cx + "," + cy + "->" + nx + "," + ny;
    }
}