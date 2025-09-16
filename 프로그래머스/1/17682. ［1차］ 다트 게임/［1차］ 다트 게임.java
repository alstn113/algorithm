class Solution {
    public int solution(String dartResult) {
        char[] chars = dartResult.toCharArray();
        int n = dartResult.length();
        int i = 0;
        int k = 0;
        int[] result = new int[3];
        while (i < n) {
            // 1
            int v;
            if (chars[i] == '1' && chars[i + 1] == '0') {
                v = 10;
                i += 1;
            } else {
                v = Integer.parseInt(dartResult.substring(i, i + 1));
            }
            result[k] = v;
            i += 1;

            // 2
            char bonus = chars[i];
            if (bonus == 'D') {
                result[k] = result[k] * result[k];
            } else if (bonus == 'T') {
                result[k] = result[k] * result[k] * result[k];
            }
            i += 1;

            // 3
            if (i == n) {
                break;
            }
            if (Character.isDigit(chars[i])) {
                k += 1;
                continue;
            }
            char option = chars[i];
            if (option == '*') {
                result[k] *= 2;
                if (k != 0) {
                    result[k - 1] *= 2;
                }
            } else if (option == '#') {
                result[k] *= -1;
            }
            i+=1;
            k += 1;
        }

        return result[0] + result[1] + result[2];
    }
}