class Solution {
    public String solution(String p) {
        if (p.isBlank() ) {
            return "";
        }
         
        int left = 0;
        int right = 0;
        boolean correct = true;
        int i = 0;
        while (i < p.length()) {
            if (p.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            if (right > left) {
                correct = false;
            }
            i += 1;

            if (left == right) {
                break;
            }
        }

        String u = p.substring(0, i);
        String v = p.substring(i);
        if (correct) {
            return u + solution(v);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < u.length() - 1; j++) {
            if (u.charAt(j) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return "(" + solution(v) + ")" + sb;
    }
}