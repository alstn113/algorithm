class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<food.length; i++) {
            String s = Integer.toString(i).repeat(food[i] / 2);
            sb.append(s);
        }
        
        StringBuilder reverse = new StringBuilder(sb).reverse();
        
        return sb.append("0").append(reverse).toString();
    }
}