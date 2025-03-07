import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // ex) 5, 16, 8, 4, 2, 1
        List<Integer> sequences = new ArrayList<>();
        while (k > 1) {
            sequences.add(k);
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
        }
        sequences.add(1);

        // 콜라츠 수열의 개수
        int n = sequences.size() - 1; // 5

        double[] sizes = new double[n + 1]; // 0일 때 포함해서 5+1 = 6개
        sizes[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            sizes[i] = sizes[i - 1] + getSize(sequences.get(i - 1), sequences.get(i));
        }

        double[] answers = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];

            if (a == b) {
                answers[i] = 0.0;
                continue;
            }

            if (a > b) {
                answers[i] = -1.0;
                continue;
            }

            if (a > n - 1) {
                answers[i] = 0.0;
                continue;
            }

            if (b > n) {
                b = n;
            }

            // ex) [0, -1] -> [0, 4]
            answers[i] = sizes[b] - sizes[a];
        }

        return answers;
    }

    private double getSize(int a, int b) {
        return (a + b) / 2.0;
    }
}
