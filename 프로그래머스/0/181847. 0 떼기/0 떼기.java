class Solution {
    public String solution(String n_str) {
        String[] splited = n_str.split("");
        int idx = 0;
        for (String s : splited) {
            if(s.equals("0")) {
                idx++;
            } else {
                break;
            }
        }
        return n_str.substring(idx);
    }
}