package kakao.s4;

// https://github.com/copilot/c/aac2888b-20dd-464f-8096-bf13920ef6b0
public class Problem4 {
    public int solution(int n, int infection, int[][] edges, int k) {
        return 0;
    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        int test1 = p.solution(10, 1,
                new int[][]{
                        {1, 2, 1},
                        {1, 3, 1},
                        {1, 4, 3},
                        {1, 5, 2},
                        {5, 6, 1},
                        {5, 7, 1},
                        {2, 8, 3},
                        {2, 9, 2},
                        {9, 10, 1}
                }, 2
        );
        boolean test1Correct = test1 == 6;
        int test2 = p.solution(7, 6,
                new int[][]{
                        {1, 2, 3},
                        {1, 4, 3},
                        {4, 5, 1},
                        {5, 6, 1},
                        {3, 6, 2},
                        {3, 7, 2}
                }, 3);
        boolean test2Correct = test2 == 7;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
    }
}
