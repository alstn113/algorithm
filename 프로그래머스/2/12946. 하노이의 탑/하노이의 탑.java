import java.util.*;


class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {

        dfs(n, 1,2,3);

        int[][] answer = list.stream().toArray(int[][]::new);
        return answer;
    }

    private void dfs(int n, int start, int mid, int end) {
        if(n==0){
            return;
        }

        dfs(n-1, start, end, mid);
        list.add(new int[]{start,end});
        dfs(n -1, mid, start,end);
    }
}