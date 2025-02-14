import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        
        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }

            
            if (c == 'S' || c == 'D' || c == 'T') {
                int v = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (c == 'D') v = v*v;
                else if (c == 'T') v = v*v*v;
                
                result.add(v);
                continue;
            }
        
            if (c == '*') {
                int size = result.size();
                result.set(size-1, result.get(size-1)*2);
                if (size > 1) result.set(size-2, result.get(size-2)*2);
            }
            
            if (c == '#') {
                int size = result.size();
                result.set(size-1, result.get(size-1)*-1);
            }
        }

        return result.stream().mapToInt(v -> v).sum();
    }
}