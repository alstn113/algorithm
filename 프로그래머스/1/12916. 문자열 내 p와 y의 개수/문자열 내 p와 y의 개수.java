class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        long pCount = s.chars().filter(c -> c == 'p').count();
        long yCount = s.chars().filter(c -> c == 'y').count();
        return pCount == yCount;
    }
}
