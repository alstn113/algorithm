class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.strip();
        while (my_string.contains("  ")) {
            my_string = my_string.replace("  ", " ");
        }
        
        return my_string.split(" ");
    }
}