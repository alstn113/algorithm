class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for (String s : myString.split("")) {
            if(s.equals("A")) {
                sb.append("B");
            } else {
                sb.append("A");
            }
        }
        if (sb.toString().contains(pat)) {
            return 1;
        }
        return 0;
    }
}