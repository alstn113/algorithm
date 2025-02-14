class Solution {

    public String solution(String s, String skip, int index) {
        char[] charArr = skip.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char k : s.toCharArray()) {
            sb.append(skipChar(k, charArr, index));
        }

        return sb.toString();
    }

    public char skipChar(char c, char[] skip, int index) {
        while (index > 0) {
            c = (char) ((c - 'a' + 1) % 26 + 'a');

            boolean flag = false;
            for (char sk : skip) {
                if (sk == c) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            index -= 1;
        }

        return c;

    }
}