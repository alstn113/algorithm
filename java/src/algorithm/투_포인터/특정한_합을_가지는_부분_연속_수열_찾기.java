package algorithm.투_포인터;

public class 특정한_합을_가지는_부분_연속_수열_찾기 {

    // 특정한 합을 가지는 부분 연속 수열 찾기 - 시간 복잡도 O(N)
    public static void main(String[] args) {

        int n = 5; // 데이터의 개수 N
        int m = 5; // 찾고자 하는 부분합 M
        int[] arr = {1, 2, 3, 2, 5}; // 전체 수열

        int count = 0;
        int intervalSum = 0;
        int end = 0;

        // start를 차례대로 증가시키며 반복
        for (int start = 0; start < n; start++) {
            // end를 가능한 만큼 이동시키기
            while (intervalSum < m && end < n) {
                intervalSum += arr[end];
                end += 1;
            }

            // 부분합이 m일 때 카운트 증가
            if (intervalSum == m) {
                count += 1;
            }

            intervalSum -= arr[start];
        }

        System.out.println(count);
    }
}
