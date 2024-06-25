import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
     List<String> answers = new ArrayList<>();

        for (int i=0; i<todo_list.length; i++) {
            if (!finished[i]) {
                answers.add(todo_list[i]);
            }
        }
        
        return answers.toArray(new String[0]);
    }
}