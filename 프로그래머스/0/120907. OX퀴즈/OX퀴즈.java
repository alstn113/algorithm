class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            int a = Integer.parseInt(parts[0]);
            String operand = parts[1];
            int b = Integer.parseInt(parts[2]);
            int answer = Integer.parseInt(parts[4]);
            System.out.println(a);
            System.out.println(operand);
            System.out.println(b);
            System.out.println(answer);
            

            if ("+".equals(operand)) {
                if (a + b == answer) {
                    result[i] = "O";
                } else {
                    result[i] = "X";
                }
            } else {
                if (a - b == answer) {
                    result[i] = "O";
                } else {
                    result[i] = "X";
                }
            }
        }
        return result;
    }
}