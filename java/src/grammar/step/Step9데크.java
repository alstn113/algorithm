package grammar.step;

import java.util.ArrayDeque;
import java.util.Deque;

public class Step9데크 {

    public static void main(String[] args) {
        // 덱(Deque) : 양쪽 끝에서 삽입과 삭제가 가능한 큐
        // addFirst, addLast, removeFirst, removeLast, peekFirst, peekLast
        // pollFirst, pollLast, offerFirst, offerLast

        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("apple");
        deque.offerLast("banana");

        System.out.println(deque.peekFirst()); // apple
        System.out.println(deque.peekLast()); // banana

        System.out.println(deque.pollFirst()); // apple
        System.out.println(deque.pollLast()); // banana

        // 반복문
        for (String item : deque) {
            System.out.println(item);
        }
        // stream
        deque.stream()
                .filter(item -> item.startsWith("b"))
                .forEach(System.out::println);
    }
}
