class Solution {
    public String solution(String p) {
        if (p.isBlank()) {
            return "";
        }

        String[] split = splitString(p);
        String u = split[0];
        String v = split[1];

        if (isCorrect(u)) {
            return u + solution(v);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();

    }

    public String[] splitString(String p) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            if (left == right) {
                break;
            }
        }

        int index = left + right;
        return new String[]{p.substring(0, index), p.substring(index)};
    }

    public boolean isCorrect(String p) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            if (right > left) {
                return false;
            }
        }

        return true;
    }
}