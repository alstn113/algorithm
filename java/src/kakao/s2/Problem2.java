package kakao.s2;

// https://github.com/copilot/c/cec61ba2-0857-4a62-b180-3c18cffd9a7d
public class Problem2 {
    public int solution(int[][] signals) {
        return 0;
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        int test1 = p.solution(new int[][]{{2, 1, 2}, {5, 1, 1}});
        boolean test1Correct = test1 == 13;
        int test2 = p.solution(new int[][]{{2, 3, 2}, {3, 1, 3}, {2, 1, 1}});
        boolean test2Correct = test2 == 11;
        int test3 = p.solution(new int[][]{{3, 3, 3}, {5, 4, 2}, {2, 1, 2}});
        boolean test3Correct = test3 == 193;
        int test4 = p.solution(new int[][]{{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}});
        boolean test4Correct = test4 == -1;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
        System.out.println("test4: " + test4Correct);
    }
}
