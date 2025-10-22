package kakao.s5;

import java.util.Arrays;

public class Problem5 {
    public int[][] solution(int[][] board, int[][] commands) {
        return null;
    }

    public static void main(String[] args) {
        Problem5 p = new Problem5();
        int[][] test1 = p.solution(
                new int[][]{
                        {0, 2, 2, 0, 0, 0, 0, 0},
                        {0, 2, 2, 0, 0, 4, 4, 0},
                        {0, 3, 3, 3, 1, 4, 4, 0},
                        {0, 3, 3, 3, 0, 0, 0, 0},
                        {0, 3, 3, 3, 5, 5, 6, 0},
                        {0, 0, 0, 0, 5, 5, 0, 0}
                },
                new int[][]{
                        {3, 1},
                        {3, 1}
                }
        );
        boolean test1Correct = Arrays.deepEquals(test1, new int[][]{
                {0, 0, 2, 2, 0, 0, 0, 0},
                {4, 4, 2, 2, 0, 0, 0, 0},
                {4, 4, 0, 3, 3, 3, 1, 0},
                {0, 0, 0, 3, 3, 3, 0, 0},
                {6, 0, 0, 3, 3, 3, 5, 5},
                {0, 0, 0, 0, 0, 0, 5, 5}
        });
        int[][] test2 = p.solution(
                new int[][]{
                        {0, 9, 1, 1, 6, 0, 0, 0},
                        {2, 2, 1, 1, 0, 0, 0, 0},
                        {2, 2, 3, 4, 4, 4, 0, 0},
                        {5, 0, 0, 4, 4, 4, 7, 0},
                        {0, 0, 0, 4, 4, 4, 8, 8},
                        {0, 0, 0, 0, 0, 0, 8, 8}
                },
                new int[][]{
                        {2, 1},
                        {3, 1},
                        {9, 2},
                        {4, 1}
                }
        );
        boolean test2Correct = Arrays.deepEquals(test2, new int[][]{
                {8, 8, 0, 1, 1, 6, 0, 0},
                {8, 8, 0, 1, 1, 0, 0, 0},
                {4, 4, 4, 9, 3, 0, 0, 0},
                {4, 4, 4, 7, 2, 2, 0, 0},
                {4, 4, 4, 0, 2, 2, 0, 0},
                {0, 5, 0, 0, 0, 0, 0, 0}
        });
        int[][] test3 = p.solution(
                new int[][]{
                        {1, 1, 0},
                        {1, 1, 0}
                },
                new int[][]{
                        {1, 4},
                        {1, 3},
                        {1, 2}
                }
        );
        boolean test3Correct = Arrays.deepEquals(test3, new int[][]{
                {0, 1, 1},
                {0, 1, 1}
        });

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
    }
}
