import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> rank = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int s : score) {
            rank.add(s);
            rank.sort(Comparator.reverseOrder());
            if(rank.size() > k) {
                rank = rank.subList(0, k);                
            }
            
            result.add(rank.get(rank.size() - 1));
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}