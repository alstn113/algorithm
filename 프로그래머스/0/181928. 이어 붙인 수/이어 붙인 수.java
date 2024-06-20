class Solution {
    public int solution(int[] num_list) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        
        for (int n: num_list) {
            if(n % 2 == 0) {
                even.append(n);
            } else {
                odd.append(n);
            }
        }
        
        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }
}