import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> prev = new HashSet<>();
        
        char prefix = words[0].charAt(words[0].length() - 1);
        prev.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char left = word.charAt(0);
            char right = word.charAt(word.length() - 1);

            if (prefix != left || prev.contains(word)) {
                return new int[]{i % n + 1, i / n+1};
            }

            prefix = right;
            prev.add(word);
        }

        return new int[]{0, 0};
    }
}