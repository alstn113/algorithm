import java.util.*;

class Solution {
    int[] dx = {1, 0, 0};
    int[] dy = {0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        
        for (int i=0; i<5; i++) {
            String[] place = places[i];
            
            if (!check(place)) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        
        return result;
    }

    // check false는 거리두기 미이행
    public boolean check(String[] place) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) { 
                if (place[i].charAt(j) != 'P') {
                    continue;
                }
                
                if (!bfs(place, i, j)) {
                    return false;
                }                    
            }
        }
        
        return true;
    }
    
    // 거리두기 미이행 시 false;
    public boolean bfs(String[] place, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[2] >= 1) {
                if (place[cur[0]].charAt(cur[1]) == 'P') {
                    return false;
                }
                
                if (cur[2] == 2) {
                    continue;
                }
            }
            
            for (int i=0; i<3; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx == x && ny == y) {
                    continue;
                }
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                
                if (place[nx].charAt(ny) == 'X') {
                    continue;
                }
                
                q.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        
        return true;
    }
}







