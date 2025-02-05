package algorithm.구간_합;

public class 누적_합과_구간_합 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] prefixSum = createPrefixSum(arr);

        System.out.println("구간 합 (1, 3): " + getRangeSum(prefixSum, 1, 3));
        System.out.println("구간 합 (0, 2): " + getRangeSum(prefixSum, 0, 2));
    }

    // 누적합 배열 생성 - 시간 복잡도 O(N)
    public static int[] createPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    // 구간 합 계산 - 시간 복잡도 O(1)
    public static int getRangeSum(int[] prefixSum, int leftIndex, int rightIndex) {
        if (leftIndex == 0) {
            return prefixSum[rightIndex];
        }
        return prefixSum[rightIndex] - prefixSum[leftIndex - 1];
    }
}
