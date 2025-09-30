import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        List<Node> nodeList = new ArrayList<>(n);

        Node node = new Node(0, null, null, true);
        nodeList.add(node);
        for (int i = 1; i < n - 1; i++) {
            Node newNode = new Node(i, node, null, true);
            node.right = newNode;
            node = newNode;
            nodeList.add(newNode);
        }
        Node tail = new Node(n - 1, node, null, true);
        node.right = tail;
        nodeList.add(tail);

        Node curNode = nodeList.get(k);
        Deque<Node> deque = new LinkedList<>();

        for (String c : cmd) {
            if (c.equals("Z")) {
                Node nv = deque.pollLast();
                nv.able = true;

                Node nvLeft = nv.left;
                if (nvLeft != null) nvLeft.right = nv;

                Node nvRight = nv.right;
                if (nvRight != null) nvRight.left = nv;

                continue;
            }

            if (c.equals("C")) {
                Node curLeft = curNode.left;
                Node curRight = curNode.right;

                curNode.able = false;
                deque.offer(curNode);

                if (curRight != null) {
                    if (curLeft != null) curLeft.right = curRight;
                    curRight.left = curLeft;
                    curNode = curRight;
                } else {
                    curLeft.right = null;
                    curNode = curLeft;
                }
                continue;
            }

            String[] split = c.split(" ");
            String action = split[0];
            int v = Integer.parseInt(split[1]);

            if (action.equals("U")) {
                while (v > 0) {
                    curNode = curNode.left;
                    v -= 1;
                }
            } else { // "D"
                while (v > 0) {
                    curNode = curNode.right;
                    v -= 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder(n);
        for (Node nv : nodeList) {
            sb.append(nv.able ? 'O' : 'X');
        }
        return sb.toString();
    }

    class Node {
        int n;
        Node left;
        Node right;
        boolean able;

        public Node(int n, Node left, Node right, boolean able) {
            this.n = n;
            this.left = left;
            this.right = right;
            this.able = able;
        }
    }
}
