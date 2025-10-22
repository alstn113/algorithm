package kakao.s1;

// https://github.com/copilot/c/1bf1d90e-0a76-4da1-85a7-ece724695bf6
public class Problem1 {

    public int solution(String message, int[][] spoiler_ranges) {
        return 0;
    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();

        int test1 = p.solution(
                "here is muzi here is a secret message",
                new int[][]{{0, 3}, {23, 28}}
        );
        boolean test1Correct = test1 == 1;

        int test2 = p.solution(
                "my phone number is 01012345678 and may i have your phone number",
                new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}}
        );
        boolean test2Correct = test2 == 4;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
    }
}
