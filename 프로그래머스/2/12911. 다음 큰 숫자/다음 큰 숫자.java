class Solution {
    public int solution(int n) {
        int currentOneCount = countBinaryOne(n);

        while (true) {
            n += 1;
            int nextOneCount = countBinaryOne(n);
            if (currentOneCount == nextOneCount) {
                return n;
            }
        }
    }

    public int countBinaryOne(int num) {
        String binary = Integer.toBinaryString(num);

        int oneCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                oneCount += 1;
            }
        }
        return oneCount;
    }
}