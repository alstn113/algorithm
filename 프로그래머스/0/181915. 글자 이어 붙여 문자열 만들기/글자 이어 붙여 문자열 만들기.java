class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        for (int n : index_list) {
            sb.append(my_string.charAt(n));
        }
        return sb.toString();
    }
}