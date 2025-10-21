package kakao;

public class Problem1 {

    public int[][] solution(String message) {
        return null;
    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        int[][] test1 = p.solution("here is muzi here is a secret message");
        boolean test1Correct = test1 == new int[][]{{0, 3}, {23, 28}};
        int[][] test2 = p.solution("my phone number is 01012345678 and may i have your phone number");
        boolean test2Correct = test2 == new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}};

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
    }
}
