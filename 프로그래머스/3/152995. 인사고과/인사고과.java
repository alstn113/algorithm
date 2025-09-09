import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

class Solution {
    public int solution(int[][] scores) {
        List<Node> nodes = new ArrayList<>();
        int targetSum = scores[0][0] + scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            nodes.add(new Node(scores[i][0], scores[i][1], i + 1));
        }
        nodes.sort((o1, o2) -> {
            if (o2.a == o1.a) {
                // a 는 내림차순 b 는 오름차순 - a가 같을 때 b가 영향주지 않기 위해
                return o1.b - o2.b;
            }
            return o2.a - o1.a;
        });

        List<Node> newNodes = new ArrayList<>();
        int maxB = -1;

        for (int i = 0; i < nodes.size(); i++) {
            Node cur = nodes.get(i);
            if (cur.b < maxB) {
                if (cur.n == 1) {
                    return -1;
                }
                continue;
            }
            maxB = Math.max(maxB, cur.b);
            newNodes.add(cur);
        }

        newNodes.sort((o1, o2) -> o2.sum() - o1.sum());
        int rank = 1;
        for (Node n : newNodes) {
            if (n.sum() == targetSum) {
                return rank;
            }
            rank += 1;
        }

        return -1;
    }

    static class Node {
        int a;
        int b;
        int n;

        public Node(int a, int b, int n) {
            this.a = a;
            this.b = b;
            this.n = n;
        }

        public int sum() {
            return a + b;
        }
    }
}