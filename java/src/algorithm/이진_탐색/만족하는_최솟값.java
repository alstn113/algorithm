package algorithm.이진_탐색;

// [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
// 출처: https://school.programmers.co.kr/learn/courses/30/lessons/340212

// 숙련도가 높으면 통과, 낮으면 실패 -> 숙련도가 최소로 통과하는 값을 구하라
public class 만족하는_최솟값 {

    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000; // diffs 의 최댓값

        while (start <= end) {
            int mid = (start + end) / 2;
            // 숙련도(mid)가 증가하면 시간이 적게 걸림. 그러므로 limit의 이하이면서 최대값을 구하는 과정
            if (calcTime(diffs, times, mid) <= limit) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start; // 통과하는 최소 숙련도
    }

    // 이거는 중요한 부분이 아닙니다.
    public long calcTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                totalTime += (long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
            }
        }

        return totalTime;
    }
}
