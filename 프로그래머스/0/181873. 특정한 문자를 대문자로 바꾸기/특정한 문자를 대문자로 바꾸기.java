class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++) {
            String s = my_string.substring(i, i+1);    
            if(s.equals(alp)) {
                sb.append(s.toUpperCase());
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}