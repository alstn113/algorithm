package kakao.s6;

public class Solution {
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        return 0;
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        int test1 = p.solution(
                3,
                new String[]{
                        ".#.##..",
                        ".#..##.",
                        ".......",
                        "##.###.",
                        ".@.#...",
                        "...#..."

                },
                new int[][]{
                        {2, 3, 4}, {2, 5, 6}, {1, 1, 1}, {3, 6, 3}
                },
                new int[][]{
                        {3, 2}, {1, 2}, {4, 1}, {4, 3}
                }
        );
        boolean test1Correct = test1 == 36;

        int test2 = p.solution(
                1,
                new String[]{
                        "@......",
                        ".######",
                        ".......",
                        "#######",
                        ".......",
                        ".####..",
                        "....#.."
                },
                new int[][]{
                        {1, 7, 4}, {1, 3, 5}, {1, 1, 3}
                },
                new int[][]{
                        {1, 3}, {3, 2}
                }
        );
        boolean test2Correct = test2 == 31;

        int test3 = p.solution(
                4,
                new String[]{
                        "........#",
                        "........#",
                        "@.......#",
                        ".#.#....#",
                        "........#",
                        "#........",
                        "#.#..####",
                        "..#..####",
                        ".....####"
                },
                new int[][]{
                        {2, 9, 1}, {2, 1, 8},
                        {1, 1, 3}, {3, 3, 2}, {1, 2, 8}
                },
                new int[][]{
                        {1, 2}, {2, 3}, {3, 4},
                        {4, 5}
                }
        );
        boolean test3Correct = test3 == 47;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
    }

}
