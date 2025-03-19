import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int[] cost : costs) {
            pq.offer(cost);
        }
        
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int from = node[0];
            int to = node[1];
            int cost = node[2];
            
            if (findParent(from, parent) != findParent(to, parent)) {
                System.out.println(from + " " + to + " " + cost);
                unionParent(from, to, parent);
                answer += cost;
            }
        }
        
        
        return answer;
    }
    
    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        
        return x = findParent(parent[x], parent);
    }
    
    public void unionParent(int a, int b, int[] parent) {
        a = findParent(a, parent);
        b = findParent(b, parent);
        
        if (a < b) {
            parent[b] = a; 
        } else {
            parent[a] = b;
        }
    }
}