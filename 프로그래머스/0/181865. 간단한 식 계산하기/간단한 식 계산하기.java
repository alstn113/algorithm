class Solution {
    public int solution(String binomial) {
        String[] binomials = binomial.split(" ");
        int result = Integer.parseInt(binomials[0]);

        for (int i = 1; i < binomials.length; i += 2) {
            switch (binomials[i]) {
                case "+":
                    result += Integer.parseInt(binomials[i + 1]);
                    break;
                case "-":
                    result -= Integer.parseInt(binomials[i + 1]);
                    break;
                case "*":
                    result *= Integer.parseInt(binomials[i + 1]);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}