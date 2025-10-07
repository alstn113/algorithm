import java.util.*;

class Solution {
    Set<Set<Integer>> set = new HashSet<>();
    
    public int solution(String[][] relation) {
        int n = relation[0].length;
        
        // 컬럼 개수마다 검증
        for (int i=1; i<=n; i++) {
            dfs(i, relation, new ArrayList<>(), 0);
        }    
        return set.size();
    }
    
            
    // contains all로 최소성 확인
    // Set 안에 key를 넣어서 확인
    public void dfs(int n, String[][] relation, List<Integer> cur, int startIdx) {
        if (n == cur.size()) {
            Set<Integer> tmp = new HashSet<>(cur);
            boolean flag = false;
            for (Set<Integer> s : set) {
                if (tmp.containsAll(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag) return;
            
            Set<String> keys = new HashSet<>();
            for (String[] r : relation) {
                StringBuilder sb = new StringBuilder();
                for (int idx : cur) {
                    sb.append(r[idx]).append(" ");
                }
                keys.add(sb.toString());
            }
            if (keys.size() == relation.length) {
                set.add(new HashSet<>(cur));
            }
            
            return;
        }
        
        for (int i=startIdx; i<relation[0].length; i++) {
            cur.add(i);
            dfs(n, relation, new ArrayList<>(cur), i+1);
            cur.remove(cur.size()-1);
        }
    }
}