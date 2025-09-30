import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 0};
    int[] dy = {0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 대기실 순회
        for (int k=0; k<5; k++) {
            
            // 각 대기실에 대해서
            String[] place = places[k];
            if (check(place)) {
                answer[k] = 1;
            }
        }
        
        return answer;
    }
    
    // false면 지키지 않는 것.
    public boolean check(String[] place) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (bfs(i, j, place)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    // true 면 지키지 않는 것.
    public boolean bfs(int x, int y, String[] place) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i=0; i<3; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >=5 || ny < 0 || ny >= 5) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (place[nx].charAt(ny) == 'X') {
                    continue;
                }
                
                if (place[nx].charAt(ny) == 'P') {
                    return true; // 거리두기 지키지 않음.
                }

                visited[nx][ny] = true;
                if (cur[2] < 1) {
                    q.offer(new int[] { nx, ny, cur[2] + 1});
                }
            }
        }
        
        return false;
    }
}








