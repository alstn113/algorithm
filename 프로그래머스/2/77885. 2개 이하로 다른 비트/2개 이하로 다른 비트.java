class Solution {
    public long[] solution(long[] numbers) {
        long[] answers = numbers.clone();
        
        for (int i = 0; i < numbers.length; i++) {
            answers[i] += 1;
            answers[i] += (answers[i] ^ numbers[i]) >> 2;
        }

        return answers;
    }
}