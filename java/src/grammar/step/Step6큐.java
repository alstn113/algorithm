package grammar.step;

import java.util.LinkedList;

public class Step6큐 {

    public static void main(String[] args) {
        // 큐(Queue) : FIFO(First In First Out) 구조
        // offer 추가, poll 제거, peek 확인 메서드 사용 (예외 처리 필요 없음)
        // add 추가, remove 제거, element 확인 메서드 사용 (예외 처리 필요)
        java.util.Queue<String> queue = new LinkedList<>();
        queue.add("apple");
        queue.add("banana");
        queue.add("kiwi");

        System.out.println(queue.peek()); // apple
        System.out.println(queue.remove()); // apple
        System.out.println(queue.size()); // 2
    }
}
