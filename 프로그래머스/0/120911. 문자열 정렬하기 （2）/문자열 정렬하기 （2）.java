import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] my_string_array = my_string.toLowerCase().split("");
        Arrays.sort(my_string_array);
        return String.join("", my_string_array);
    }
}