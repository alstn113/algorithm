class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for (int width = 3; width <= sum / 2; width++) {
            if (sum % width != 0) continue;
            
            int height = sum / width;
            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = height;
                answer[1] = width;
                break;
            }
        }
        return answer;
    }
}