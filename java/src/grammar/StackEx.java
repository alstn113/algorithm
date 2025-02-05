package grammar;

import java.util.*;

public class StackEx {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 맨 위 요소 확인
        System.out.println(stack.peek()); // 3 (없으면 예외 발생)

        // 맨 위 요소 제거
        System.out.println(stack.pop()); // 3

        // 요소 개수
        System.out.println(stack.size()); // 2

        // 요소 포함 여부
        System.out.println(stack.contains(1)); // true

        // 요소 순회
        for (Integer i : stack) {
            System.out.println(i);
        }

        // 요소 비우기
        // stack.clear();

        // 비어있는지 확인
        System.out.println(stack.isEmpty());
    }
}
