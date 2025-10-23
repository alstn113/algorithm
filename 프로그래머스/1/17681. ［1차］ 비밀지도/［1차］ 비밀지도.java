class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            String v = Integer.toBinaryString(arr1[i] | arr2[i]);
            while(v.length() < n) {
                v = "0" + v;
            }
            
            v = v.replaceAll("1", "#");
            v = v.replaceAll("0", " ");
            answer[i] = v;
        }
        
        return answer;
    }
}