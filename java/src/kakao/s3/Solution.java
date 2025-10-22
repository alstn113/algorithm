package kakao.s3;

import java.util.TreeMap;

// 분배 노드는 자식 노드를 2개 또는 3개 가진다.
// 같은 깊이의 분배 노드는 동일한 자식 수를 가진다. - 분배 노드 또는 리프 노드가 될 수 있음.

public class Solution {

    public int solution(int dist_limit, int split_limit) {
        if (dist_limit == 0) {
            return 1;
        }

        TreeMap<Long, Long> leafCounts = new TreeMap<>(); // 분배도 - 리프 노드 수

        long totalLeaves = 1L;
        leafCounts.put(1L, 1L);

        long distNodesLeft = dist_limit;

        while (distNodesLeft > 0 && !leafCounts.isEmpty()) {
            long currentSplit = leafCounts.firstKey(); // 분배도
            long numLeaves = leafCounts.remove(currentSplit);

            long nodesToExpand = Math.min(numLeaves, distNodesLeft);

            if (numLeaves > nodesToExpand) {
                leafCounts.put(currentSplit, numLeaves - nodesToExpand);
            }

            boolean can3split = (currentSplit * 3 <= split_limit);
            boolean can2split = (currentSplit * 2 <= split_limit);

            boolean isCritical =
                    can2split && (currentSplit * 2 * 3 <= split_limit) && (currentSplit * 3 * 3 > split_limit);

            if (can3split && !isCritical) {
                totalLeaves += 2 * nodesToExpand;
                distNodesLeft -= nodesToExpand;
                leafCounts.merge(currentSplit * 3, 3 * nodesToExpand, Long::sum);
            } else if (can2split) {
                totalLeaves += nodesToExpand;
                distNodesLeft -= nodesToExpand;
                leafCounts.merge(currentSplit * 2, 2 * nodesToExpand, Long::sum);
            } else {
                leafCounts.merge(currentSplit, nodesToExpand, Long::sum);
                break;
            }
        }

        return (int) totalLeaves;
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
