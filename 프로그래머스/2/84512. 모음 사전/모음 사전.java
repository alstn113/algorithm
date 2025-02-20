class Solution {
    static int answer = 0;

    public int solution(String word) {
        String[] alphabet = {"A", "E", "I", "O", "U"};

        for (String a : alphabet) {
            if (dfs(a, word, alphabet)) {
                return answer;
            }
        }

        return 0;
    }

    public boolean dfs(String current, String target, String[] data) {
        answer++;

        if (current.equals(target)) {
            return true;
        }
        if (current.length() == 5) {
            return false;
        }

        for (String a : data) {
            if (dfs(current + a, target, data)) {
                return true;
            }
        }

        return false;
    }
}
