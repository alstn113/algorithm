import java.util.LinkedList;
import java.util.Queue;

class QueueEx {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 요소 추가
        queue.add(1); // 문제 발생 시 예외 발생
        queue.offer(2); // 문제 발생 시 false 반환

        // 큐에서 요소 제거
        queue.remove(); // 문제 발생 시 예외 발생
        queue.poll(); // 문제 발생 시 null 반환

        // 큐 비우기
        queue.clear();

        // 큐가 비어있는지 확인
        queue.isEmpty();

        // 큐의 길이
        queue.size();

        // 큐의 맨 앞 요소 확인
        queue.element(); // 문제 발생 시 예외 발생
        queue.peek(); // 문제 발생 시 null 반환
    }
}
