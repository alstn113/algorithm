import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        // 높이로 정렬
        List<Node> arr = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            arr.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        arr.sort((o1, o2) -> o2.y - o1.y);

        Node root = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            dfs(root, arr.get(i));
        }

        List<Integer> bfResult = new ArrayList<>();
        bfIter(bfResult, root);
        List<Integer> afResult = new ArrayList<>();
        afIter(afResult, root);

        return new int[][]{
                bfResult.stream().mapToInt(v -> v).toArray(),
                afResult.stream().mapToInt(v -> v).toArray()
        };
    }

    public void bfIter(List<Integer> bfResult, Node node) {
        bfResult.add(node.num);
        if (node.left != null) {
            bfIter(bfResult, node.left);
        }
        if (node.right != null) {
            bfIter(bfResult, node.right);
        }
    }

    public void afIter(List<Integer> afResult, Node node) {
        if (node.left != null) {
            afIter(afResult, node.left);
        }
        if (node.right != null) {
            afIter(afResult, node.right);
        }
        afResult.add(node.num);
    }

    public void dfs(Node target, Node cur) {
        if (target.x < cur.x) {
            if (target.right == null) {
                target.right = cur;
            } else {
                dfs(target.right, cur);
            }
        } else {
            if (target.left == null) {
                target.left = cur;
            } else {
                dfs(target.left, cur);
            }
        }
    }

    class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
}