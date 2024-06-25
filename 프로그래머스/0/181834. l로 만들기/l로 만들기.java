class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) < 'l') {
                sb.append("l");
            } else {
                sb.append(myString.charAt(i));
            }
        }
        return sb.toString();
    }
}