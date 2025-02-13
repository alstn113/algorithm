class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int v = nums[i]+nums[j]+nums[k];
                    answer += isPrime(v);
                }
            }
        }
        
        return answer;
    }
    
    public int isPrime(int n) {
        for (int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return 0;
        }
        return 1;
    }
}