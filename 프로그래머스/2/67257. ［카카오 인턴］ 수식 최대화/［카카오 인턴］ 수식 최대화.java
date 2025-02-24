public class Solution {

    static String[][] cases = {
            {"\\*", "\\+", "\\-"},
            {"\\*", "\\-", "\\+"},
            {"\\+", "\\*", "\\-"},
            {"\\+", "\\-", "\\*"},
            {"\\-", "\\*", "\\+"},
            {"\\-", "\\+", "\\*"}
    };

    public static long solution(String expression) {
        long maxAnswer = 0;
        for (String[] order : cases) {
            long value = evaluate(expression, order, 0);
            maxAnswer = Math.max(maxAnswer, Math.abs(value));
        }
        return maxAnswer;
    }

    public static long evaluate(String expression, String[] order, int n) {
        String[] tokens = expression.split(order[n]);
        long result = getValue(tokens[0], order, n);

        for (int i = 1; i < tokens.length; i++) {
            long temp = getValue(tokens[i], order, n);

            if (order[n].equals("\\*")) {
                result *= temp;
            } else if (order[n].equals("\\+")) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        return result;
    }

    private static long getValue(String token, String[] order, int n) {
        if (n == 2) {
            return Long.parseLong(token);
        }
        return evaluate(token, order, n + 1);
    }
}
