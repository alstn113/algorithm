import java.util.Stack;

class Solution {
    public int solution(String s) {
        if (!isValid(s)) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(i) + s.substring(0, i);

            Stack<Character> stack = new Stack<>();
            for (char ch : newStr.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }

                char top = stack.peek();
                if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                    stack.pop();
                    continue;
                }

                stack.push(ch);
            }
            
            if (stack.isEmpty()) {
                cnt += 1;
            }
        }

        return cnt;
    }

    public boolean isValid(String s) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                a += 1;
            } else if (ch == ')') {
                a -= 1;
            } else if (ch == '{') {
                b += 1;
            } else if (ch == '}') {
                b -= 1;
            } else if (ch == '[') {
                c += 1;
            } else if (ch == ']') {
                c -= 1;
            }
        }

        return a == 0 && b == 0 && c == 0;
    }
}