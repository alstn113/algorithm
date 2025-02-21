import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);

            return b - a;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        String answer = sb.toString();

        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }
}