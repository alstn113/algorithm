class Solution {
    public int solution(int hp) {
        int result = 0;
        result += hp / 5;
        hp %= 5;
        result += hp / 3;
        hp %= 3;
        result += hp / 1;
        hp %= 1;
        return result;
    }
}