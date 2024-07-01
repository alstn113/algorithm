class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;

        for (int a = i; a <= j; a++) {
            count += (int) String.valueOf(a).chars().filter(c -> c - '0' == k).count();
        }

        return count;
    }
}