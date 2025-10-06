class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] b = new char[m][n];
        for (int i=0; i<m; i++) {
            b[i] = board[i].toCharArray();
        }
        int result = 0;
    
        while(true) {
            // 동일한 판 복사
            char[][] nb = new char[m][n];
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    nb[i][j] = b[i][j];
                }
            }
            
            // 같은거 찾기
            for (int i=1; i<m; i++) {
                for (int j=1; j<n; j++) {
                    char c = b[i][j];
                    
                    if (c == '#') continue;
                    
                    char c1 = b[i][j-1];
                    char c2 = b[i-1][j];
                    char c3 = b[i-1][j-1];
                    
                    if (c == c1 && c == c2 && c == c3) {
                        nb[i][j] = '@';
                        nb[i-1][j] = '@';
                        nb[i][j-1] = '@';
                        nb[i-1][j-1] = '@';
                    }
                }
            }
            
            // 마킹한 것 빈 칸으로 변경
            int tmp = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (nb[i][j] == '@') {
                        tmp += 1;
                        nb[i][j] = '#';
                    }
                }
            }
            if(tmp == 0) {
                break;
            }
            result += tmp;
            
            
            // 아이템 내리기
            for (int i=0; i<n; i++) { 
                for (int j=m-2; j>-1; j--) {
                    int targetIdx = j+1;
                    while(targetIdx < m && nb[targetIdx][i] == '#') {
                        targetIdx += 1;
                    }
                    
                    char cur = nb[j][i];
                    nb[j][i] = nb[targetIdx-1][i];
                    nb[targetIdx-1][i] = cur;
                }
            }
            
            // 판 교체
            b = nb;
        }
        
        return result;
    }
}