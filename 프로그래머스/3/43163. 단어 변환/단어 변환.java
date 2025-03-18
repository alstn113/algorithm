class Solution {
    static boolean[] visited;
    static int answer = (int) 1e9;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        if (answer == (int) 1e9) return 0;
        return answer;
    }
    
    public void dfs(String current, String target, String[] words, int cnt) {
        if (current.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            if(!check(current, words[i])) continue;
            if(visited[i]) continue;
                
            visited[i] = true;
            dfs(words[i], target, words, cnt+1);
            visited[i] = false;
        }        
    }
    
    public boolean check(String a, String b) {
        boolean flag = false;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        
        if (flag) {
            return true; // 한 자리만 다른 것.
        }
        return false; // 같은 것.
    }
}