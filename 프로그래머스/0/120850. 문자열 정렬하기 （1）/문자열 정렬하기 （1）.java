import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        char[] charArray = my_string.toCharArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                result.add(Character.getNumericValue(charArray[i]));
            }
        }
        return result.stream().mapToInt(i -> i).sorted().toArray();
    }
}