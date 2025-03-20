package algorithm.투_포인터;

// 연속된 데이터를 다룰 때, 고정된 크기의 윈도우(부분 배열, 부분 문자열)를 이동시키면서 문제를 해결하는 방법
// 연속된 부분을 다루고, 최대값, 최소값, 합, 평균 등의 계산을 여러 번 수행할 경우 O(N^2)의 시간복잡도를 가지는 문제를 O(N)으로 해결할 수 있음
public class 슬라이딩_윈도우 {

    // k 길이의 구간에서 합이 가장 큰 값을 찾는 문제
    public int Solution(int[] stones, int k) {
        int n = stones.length;
        if (n < k) {
            return -1;
        }

        // 첫 번째 윈도우의 합
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += stones[i];
        }

        int answer = sum;

        // 두 번째 윈도우부터 마지막 윈도우까지
        for (int i = k; i < n; i++) {
            sum += stones[i] - stones[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        슬라이딩_윈도우 solution = new 슬라이딩_윈도우();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution.Solution(stones, k)); // 3
    }
}
