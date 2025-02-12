class Solution {
    public String solution(String p) {
        return "*".repeat(p.length() - 4) + p.substring(p.length() - 4);
    }
}