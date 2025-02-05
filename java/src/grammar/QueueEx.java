package grammar;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 요소 추가
        queue.add(1); // (문제 시 예외 발생)
        queue.offer(2); // (문제 시 false 반환)

        // 맨 앞 요소 확인
        System.out.println(queue.element()); // (문제 시 예외 발생)
        System.out.println(queue.peek()); // (문제 시 null 반환)

        // 맨 앞 요소 제거
        System.out.println(queue.remove()); // (문제 시 예외 발생)
        System.out.println(queue.poll()); // (문제 시 null 반환)

        // 요소 개수
        System.out.println(queue.size());

        // 요소 포함 여부
        System.out.println(queue.contains(1));

        // 요소 순회
        for (Integer i : queue) {
            System.out.println(i);
        }

        // 요소 비우기
        // queue.clear();

        // 비어있는지 확인
        System.out.println(queue.isEmpty());
    }
}
