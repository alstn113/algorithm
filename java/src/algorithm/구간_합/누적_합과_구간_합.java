package algorithm.구간_합;

// 0-based 누적합
public class 누적_합과_구간_합 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] prefixSum = createPrefixSum(arr);

        System.out.println("구간 합 (1, 3): " + getRangeSum(prefixSum, 1, 3)); // 20 + 30 + 40 = 90
        System.out.println("구간 합 (0, 2): " + getRangeSum(prefixSum, 0, 2)); // 10 + 20 + 30 = 60
    }

    // 누적합 배열 생성 - prefixSum[i] = arr[0] ~ arr[i-1]까지 합
    public static int[] createPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1]; // 길이 + 1
        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        return prefixSum;
    }

    // 구간 합 계산: arr[leftIndex] ~ arr[rightIndex]
    public static int getRangeSum(int[] prefixSum, int leftIndex, int rightIndex) {
        return prefixSum[rightIndex + 1] - prefixSum[leftIndex];
    }
}
