package kakao.s3;

// https://github.com/copilot/c/aac2888b-20dd-464f-8096-bf13920ef6b0
public class Problem3 {
    public int solution(int dist_limit, int split_limit) {
        return 0;
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();
        int test1 = p.solution(3, 6);
        boolean test1Correct = test1 == 6;
        int test2 = p.solution(0, 10);
        boolean test2Correct = test2 == 1;
        int test3 = p.solution(3, 100);
        boolean test3Correct = test3 == 7;
        int test4 = p.solution(5, 16);
        boolean test4Correct = test4 == 9;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
        System.out.println("test4: " + test4Correct);
    }
}
