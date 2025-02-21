class Solution {
    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;

        while (n >= 0) {
            for (int i = 0; i < n; i++) {
                x += 1;
                answer[x][y] = num++;
            }
            n -= 1;

            for (int i = 0; i < n; i++) {
                y += 1;
                answer[x][y] = num++;
            }
            n -= 1;

            for (int i = 0; i < n; i++) {
                x -= 1;
                y -= 1;
                answer[x][y] = num++;
            }
            n -= 1;
        }

        int[] result = new int[num - 1];
        int index = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (answer[i][j] == 0) {
                    break;
                }
                result[index++] = answer[i][j];
            }
        }
        
        return result;
    }
}