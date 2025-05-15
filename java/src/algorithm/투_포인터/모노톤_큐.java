package algorithm.투_포인터;

import java.util.*;

// 관련 문제: https://school.programmers.co.kr/learn/courses/30/lessons/64062
// 모노톤 큐란 큐의 원소들이 증가하거나 감소하는 순서로 저장되어 있는 큐를 말함
// 큐의 앞에는 최대값이 위치함. 큐의 뒤에는 최소값이 위치함

// 장정: 슬라이딩 윈도우 범위에서 최댓값 또는 최솟값을 빠르게 구해야할 때
public class 모노톤_큐 {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int answer = (int) 1e9;

        for (int i = 0; i < stones.length; i++) {
            // 현재 윈도우 범위를 벗어난 요소 제거
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 새로운 요소 추가할 때, 현재 값보다 작은 값들은 필요 없음 (덱에서 제거)
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            // 인덱스를 덱에 추가
            deque.offerLast(i);

            // 첫 번째 윈도우가 만들어진 후부터 최대값 저장
            if (i >= k - 1) {
                answer =  Math.min(answer, stones[deque.peekFirst()]);
            }
        }

        // 최대값들 중에서 최소값 찾기
        return answer;
    }

    public static void main(String[] args) {
        모노톤_큐 solution = new 모노톤_큐();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution.solution(stones, k));
    }
}
