import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> st = new Stack<>();
        for (String str : s.split("")) {
            if (st.size() > 0) {
                if (st.peek().equals(str)) {
                    st.pop();
                    continue;
                }
            }            
            
            st.push(str);
        }
        
        if (st.isEmpty()) {
            return 1;
        }
        return 0;
    }
}