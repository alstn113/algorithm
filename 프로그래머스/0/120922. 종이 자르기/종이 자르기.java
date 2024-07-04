class Solution {
    public int solution(int M, int N) {
        if (M > N) {
            return (M-1)+(N-1)*M;            
        } 
        return (N-1)+(M-1)*N;            
    }
}