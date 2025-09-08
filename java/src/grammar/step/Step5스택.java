package grammar.step;

import java.util.Stack;

public class Step5스택 {

    public static void main(String[] args) {
        // 스택(Stack) : LIFO(Last In First Out) 구조
        // push() : 스택에 요소 추가
        // pop() : 스택에서 요소 제거
        // peek() : 스택의 가장 위에 있는 요소를 반환 (제거하지 않음)
        // contains() : 스택에 특정 요소가 포함되어 있는지 확인
        // clear() : 스택의 모든 요소를 제거
        // isEmpty() : 스택이 비어있는지 확인
        // size() : 스택의 크기를 반환

        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("kiwi");

        System.out.println(stack.peek()); // kiwi
        System.out.println(stack.pop()); // kiwi
        System.out.println(stack.size()); // 2
    }
}
