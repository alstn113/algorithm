class Solution {
    public int[] solution(int[][] score) {
        double[] map = new double[score.length];
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            map[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        for (int i = 0; i < score.length; i++) {
            int cnt = 0;
            for (int j = 0; j < score.length; j++) {
                if (map[i] < map[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt + 1;
        }

        return answer;
    }
}