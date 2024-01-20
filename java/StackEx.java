import java.util.Stack;

class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 길이
        System.out.println(stack.size()); // 3

        // 맨 위 값 확인
        System.out.println(stack.peek()); // 3

        // 맨 위 값 삭제
        System.out.println(stack.pop()); // 3

        // 맨 위 값 확인
        System.out.println(stack.peek()); // 2

        // 비어있는지 확인
        System.out.println(stack.isEmpty()); // false

        // 포함하는지 확인
        System.out.println(stack.contains(1)); // true

        // 비우기
        stack.clear();

        // 비어있는지 확인
        System.out.println(stack.isEmpty()); // true
    }
}
