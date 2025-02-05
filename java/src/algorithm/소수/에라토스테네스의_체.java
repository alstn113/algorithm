package algorithm.소수;

import java.util.*;

public class 에라토스테네스의_체 {

    public static int n = 100; // 2부터 1000까지의 모든 수를 대상으로 소수 판별
    public static boolean[] arr = new boolean[n + 1];

    public static void main(String[] args) {
        Arrays.fill(arr, true); // 처음엔 모든 수가 소수(True)인 것으로 초기화(0과 1은 제외)

        for (int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지의 모든 수를 확인
            if (arr[i]) { // i가 소수인 경우 (아직 지워지지 않은 숫자인 경우)
                // i를 제외한 i의 모든 배수를 지우기
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j += 1;
                }
            }
        }

        // 모든 소수 출력
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
