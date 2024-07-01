class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        for(int i=0; i < myString.length() - pat.length() + 1; i++) {
            if (myString.startsWith(pat, i)) {
                cnt += 1;
            }
        }
        return cnt;
    }
}