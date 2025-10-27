package kakao.s3;

public class Solution {

    public int solution(int dist_limit, int split_limit) {
        int dist = 1;
        int sum = 1;
        int curLeaf = 1;

        while (dist_limit > 0) {
            int ables = Math.min(curLeaf, dist_limit);
            dist_limit -= ables;

            boolean can3to3 = dist * 9 <= split_limit;
            boolean can2to3 = dist * 6 <= split_limit;
            boolean can3 = dist * 3 <= split_limit;
            boolean can2 = dist * 2 <= split_limit;
            boolean isCritical = can2 && can2to3 && !can3to3;

            if (can3 && !isCritical) {
                sum += 2 * ables;
                curLeaf = ables * 3;
                dist = dist * 3;
            } else if (can2) {
                sum += ables;
                curLeaf = ables * 2;
                dist = dist * 2;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test1 = s.solution(3, 6);
        boolean test1Correct = test1 == 6;
        int test2 = s.solution(0, 10);
        boolean test2Correct = test2 == 1;
        int test3 = s.solution(3, 100);
        boolean test3Correct = test3 == 7;
        int test4 = s.solution(5, 16);
        boolean test4Correct = test4 == 9;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
        System.out.println("test4: " + test4Correct);
    }
}
